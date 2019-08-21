package com.lhb.log02;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

public class Demo02 {
	// case1.log4j日志实现类下  使用默认路径下的配置文件  并直接调用log4j的接口实现类
	// private final static Logger log1 = LogManager.getLogger(Demo02.class);
	
	// case2.log4j日志实现类下  配置文件为自定义路径自定义名称
	// private final static Logger log2 = LogManager.getLogger(Demo02.class);
	
	// case3.slf4j+log4j  默认配置文件
	//private final static org.slf4j.Logger log3 = LoggerFactory.getLogger(Demo02.class);
	
	// case4.slf4j+log4j  自定义配置文件名称与路径
	private final static org.slf4j.Logger log4 = LoggerFactory.getLogger(Demo02.class);
	
	public static void main(String[] args) {
		// case1.测试打印
		// log1.debug("直接调用log4j的实现类");
		
		// case2.读取指定路径下的配置文件  
		/*String path = "resource/properties/log4j01.properties";
		PropertyConfigurator.configure(path);
		log2.error("这是case2");*/
		
		// case3.slf4j+log4j  默认配置文件
		//log3.debug("这是case 模式为：slf4j+log4j  配置文件为默认路径默认名称");
		
		// case4.slf4j+log4j  自定义配置文件
		String path = "resource/properties/log4j01.properties";
		PropertyConfigurator.configure(path);
		log4.debug("这是case 模式为：slf4j+log4j  自定义配置文件");
	}
	
	
}
