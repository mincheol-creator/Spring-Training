package myspring.di.xml;

public class ConsolePrinter implements Printer {
	public ConsolePrinter() {
		System.out.println("ConsolePrinter COnstructor ȣ�� ��");
	}
	public void print(String message) {
		System.out.println(message);
	}
}
