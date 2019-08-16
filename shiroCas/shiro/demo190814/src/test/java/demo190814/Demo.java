package demo190814;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application.xml")
public class Demo {
	// private final Logger log = LoggerFactory.getLogger(Demo.class);
	
	@Test
	public void test(){
		Logger log = LogManager.getLogger();
		log.error("============test========LHB");
		log.info("============test========LHB");
		
		org.slf4j.Logger log2 = LoggerFactory.getLogger(Demo.class);
		log2.error("============test2========LHB");
		log2.info("============test2========LHB");
		
		String path=System.getProperty("catalina.home");
		log.error("tomcat的访问路径==controller层的日志信息=="+path);
		log.info("tomcat的访问路径==controller层的日志信息=="+path);
	}
}
