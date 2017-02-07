package springAOP;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		String url = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(url);
		Calc calc = ac.getBean("calc", Calc.class);
		System.out.println(calc.add(3, 4));
	}
}
