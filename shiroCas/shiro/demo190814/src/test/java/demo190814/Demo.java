package demo190814;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class Demo {
	private final Logger log = LoggerFactory.getLogger(Demo.class);
	
	@Test
	public void test(){
		log.error("============test========LHB");
	}
}
