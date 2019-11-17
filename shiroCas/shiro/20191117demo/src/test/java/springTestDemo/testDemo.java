package springTestDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lhb.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/application.xml"})
public class testDemo {
	
	@Autowired
	private IUserService userSerivce;
	
	
	@Test
	public void userDemo() {
		userSerivce.getStudent();
	}
		
}
