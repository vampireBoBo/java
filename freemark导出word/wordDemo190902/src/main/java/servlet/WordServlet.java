package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

@SuppressWarnings("serial")
@WebServlet(description="word文档下载",value="/servlet/word")
public class WordServlet extends HttpServlet {
	/**
	 * 根据参数  和word模板   生成word文档
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		List<Student> stuList = new ArrayList<Student>();
		for(int i=1;i<4;i++){
			Student stu = new Student();
			stu.setNo("0"+i);
			stu.setName("lyx"+i);
			stu.setGender("帅哥"+i);
			stu.setPhone("13518754870");
			stuList.add(stu);
		}
		
		// 读取模板 
		try {
			// 读取模板
			Configuration config = new Configuration();
			config.setEncoding(Locale.getDefault(),"UTF-8");
			config.setDefaultEncoding("UTF-8");
			// 设置异常处理器,这样的话就可以${a.b.c.d}即使没有属性也不会出错
			config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
			config.setClassForTemplateLoading(this.getClass(), "/wordTemplate");
			Template t = null;
			File file = null;
			InputStream in = null;
			t = config.getTemplate("student.ftl");
			
			// 指定位置生成文件
			String path = req.getSession().getServletContext().getRealPath("lhb.doc");
			File outFile = new File(path);
			Writer out = new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8");
			
			//Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"), 10240);
			Map<String,Object> params = new HashMap();
			params.put("stuList", stuList);
			params.put("title","测试该字段的非必要行");
			t.process(params, out);
			out.close();
			
			// 响应前端 文件下载
			in = new FileInputStream(outFile);
			String fileName = "lhb.doc";
			rep.setCharacterEncoding("UTF-8");
			rep.setContentType("application/msword");
			rep.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
			ServletOutputStream servletOut = rep.getOutputStream();
			byte[] buffer = new byte[1024]; 
			int byteIndex = -1;
			while((byteIndex = in.read(buffer))!=-1){
				servletOut.write(buffer,0,byteIndex);
			}
			
			if(servletOut!=null){
				servletOut.close();
			}
			if(in!=null){
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//super.doGet(req, resp);
	}
}
