package com.lhb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhb.entity.Music;
/**
 * 音乐资源视图层  用户登录即可正常访问
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/music")
public class MusicController {
	private final Logger log = LogManager.getLogger();
	/**
	 * 登录
	 * @return  返回结果值
	 */
	@RequiresRoles(value={"admin","user"},logical=Logical.OR)
	@GetMapping(value="/manageList")
	public ModelAndView login(HttpServletResponse rep){
		ModelAndView view = new ModelAndView("/music/manage");
		List<Music> list = new ArrayList<Music>();
		for(int i=1;i<6;i++){
			Music music = new Music();
			music.setId(String.valueOf(i));
			music.setName("love yourself "+i);
			music.setAuthor("lhb");
			music.setCreateTime(new Date());
			list.add(music);
		}
		view.getModel().put("list", list);
		view.getModel().put("key","LHB");
		return view;
	}
}
