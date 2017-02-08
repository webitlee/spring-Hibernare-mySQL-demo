package springAOP;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args){
		String url = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(url);
		CalcImplment calc = (CalcImplment)ac.getBean("calc");
		calc.add(4, 3);
		calc.minus(6, 1);
		calc.mod(5, 3);
		int result = calc.div(5, 3);
		System.out.println(result);
	}
}
