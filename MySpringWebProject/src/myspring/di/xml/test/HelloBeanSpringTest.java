package myspring.di.xml.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

//SpringJUnit4ClassRunner�� TestCase�� ���� ���ָ鼭
//Spring�����̳� ������ �ϴ� ApplicationContext ��ü�� ������ �ش�.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloBeanSpringTest {
	//factory.getBean("hello")
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
//	@Autowired
//	@Qualifier("conPrinter")
//	Printer printer;
	
	@Test
	public void helloBean() {
		System.out.println(hello.sayHello());
		hello.print();
		
		List<String> names = hello.getNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
