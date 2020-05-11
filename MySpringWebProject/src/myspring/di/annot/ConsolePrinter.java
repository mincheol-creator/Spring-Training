package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinter implements Printer {
	public ConsolePrinter() {
		System.out.println("ConsolePrinter Constructor ȣ�� ��");
	}
	public void print(String message) {
		System.out.println(message);
	}
}
