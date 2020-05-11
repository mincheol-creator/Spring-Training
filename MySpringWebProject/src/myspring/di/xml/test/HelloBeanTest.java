package myspring.di.xml.test;
//static import : static method�� import ���ش�.
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	BeanFactory factory;
	
	//@Before -> @Test
	@Before
	public void init() {
		//1. Spring Bean Container ��ü����
		factory = new GenericXmlApplicationContext("config/spring_beans.xml");
		
	}
	
	@Test
	public void helloBean() {
		//2. Container���� Bean�� ��û
		//Hello hello = new Hello() (X)
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		//3. Bean�� Singleton ��ü������ Ȯ��
		System.out.println(hello==hello2);
		//assertSame() �ż��带 ����ؼ� �ּ� ��
		assertSame(hello, hello2);
		//assertEquals() �ż��带 ����ؼ� ���� ��
		assertEquals("Hello ������", hello.sayHello());
		
		hello.print();
		
		//stringPrinter Bean�� ��û
		Printer printer = factory.getBean("strPrinter", Printer.class);
		assertEquals("Hello ������", printer.toString());
	}

}
