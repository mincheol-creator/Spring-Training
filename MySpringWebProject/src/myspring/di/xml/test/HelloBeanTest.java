package myspring.di.xml.test;
//static import : static method를 import 해준다.
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
		//1. Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("config/spring_beans.xml");
		
	}
	
	@Test
	public void helloBean() {
		//2. Container에게 Bean을 요청
		//Hello hello = new Hello() (X)
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		//3. Bean이 Singleton 객체인지를 확인
		System.out.println(hello==hello2);
		//assertSame() 매서드를 사용해서 주소 비교
		assertSame(hello, hello2);
		//assertEquals() 매서드를 사용해서 값을 비교
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		
		//stringPrinter Bean을 요청
		Printer printer = factory.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}

}
