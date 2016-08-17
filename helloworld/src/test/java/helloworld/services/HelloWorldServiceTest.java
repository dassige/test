/**
 * 
 */
package helloworld.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.dassi.helloworld.services.HelloWorldService;

/**
 * @author dassig
 *
 */
public class HelloWorldServiceTest {
	private HelloWorldService service;
	private ApplicationContext context;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		this.service = (HelloWorldService) context.getBean("helloWorldService");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sayHello() {
		service.setName("TEST");
		String message = service.sayHello();

		assertNotNull(message);
		assertTrue(message.length()> 0);
		assertEquals("Hello! TEST", message);
		
	}

}
