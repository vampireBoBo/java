package com.lhb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhb.service.IndexService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/index")
@Slf4j
public class IndexController {
	
	@Autowired()
	private IndexService indexService;
	
	@RequestMapping("/toview")
	public String toView(){
		try {
			String path = indexService.getView();
			log.trace("trace");
			log.debug("debug");
			log.info("info");
			log.warn("warn");
			log.error("error");
			//log.info("controller调用service层接口读取的项目路径为==="+path);
			System.out.println("日志打印完毕");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "main";
	}
	
}
