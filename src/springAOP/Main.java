package springAOP;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		String url = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(url);
		CalcImplment calc = ac.getBean("calc", CalcImplment.class);
		System.out.println(calc.add(3, 4));
	}
}
