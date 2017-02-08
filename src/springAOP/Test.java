package springAOP;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args){
		String url = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(url);
		CalcImplment calc = (CalcImplment)ac.getBean("calc");
		System.out.println(calc.add(3, 4));
	}
}
