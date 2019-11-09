1、集成spring

	1.pom引入spring-core  spring-web
	2.web.xml 配置sprig配置spring容器的监听
	3、创建spring的application.xml，在文件中开启包的扫描  开启注解
	
2、集成spring-test进行接口测试
	
	
	1.pom添加依赖 spring-test  junit  spring=context，需要注意junit的版本在4以上 否则找不到@RunWith的提供包 .spring-test中需要spring-context的依赖故需要引入spring-context，否则加入注解@ContextConfiguration 时  会package报错  并且该注解内的元素通过提示功能没有任何显示。
	2、 创建父类  设置注解   子类进行继承  然后启动报错：Could not detect default configuration classes for test class [com.base.SpringTestBase]: SpringTestBase does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
	
	单独给子类添加注解 进行测试时  程序运行正常
	
	java.lang.IncompatibleClassChangeError: Implementing class
	
	TODO LHB

3、继承cxf 发布webservice服务

	1.添加pom依赖  cxf-rt-frontend-jaxws  cxf-rt-transports-http
	2.web.xml 配置cxf的servlet
	3、在需要外放的class类添加@WebService  在需要外放的接口 添加@WebMethod
	4.在application.xml 发布webservice接口
	5.在浏览器中通过连接?wsdl 查看xml文档是否正常显示
	
	【
		webservice的发布有两种分风格，一种是wsdl使用的发布类是cxf-rt-frontend-jaxws   ，另外一种是restful风格使用的工具是cxf-rt-frontend-jaxrs 
	】
	
4、使用soapUI工具测试接口
	
	1.下载soapUI http://www.3322.cc/soft/14387.html
	2、根据wsdl创建对应的soap project 执行测试
	
5、使用html 通过  原始xmlhttprequest 调用 webservice
	
	1.创建文件夹 创建对应的参数  及静态页面
	2.跨域：问题===通过soapUI 的请求报文格式 去发送请求  服务器响应成功 但是浏览器解析跨域异常 No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'null' is therefore not allowed access.解决方案===在web.xml 添加过滤filter<filter>  
	     <filter-name>CorsFilter</filter-name>  
	     		 <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>  
		</filter>  
		<filter-mapping>  
		      <filter-name>CorsFilter</filter-name>  
		      <url-pattern>/*</url-pattern>  
		</filter-mapping>  
		
	3、使用xml调用时如何根据接口的wsdl查看请求的报文格式，
	![Image text](http://127.0.0.1:8080/20191106demo/xml.png)
	获取方式：通过soapUI即可查看到对应的请求报文格式，注意事项如上图所示。
	
6、使用java调用
7、使用ajax调用






