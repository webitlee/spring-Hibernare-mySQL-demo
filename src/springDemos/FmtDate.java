package springDemos;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FmtDate {

	public static void main(String[] args) {
		String url = "applicationContext.xml";
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(url);
		Date date = ac.getBean("date", Date.class);
		//System.out.println(date);
		//Calendar calendar = ac.getBean("calendar", Calendar.class);
		//System.out.println(calendar);
		//Date time = ac.getBean("time", Date.class);
		//System.out.println(time);
		//InitMethod init = ac.getBean("init", InitMethod.class);
		//DestoryMethod destroy = ac.getBean("destory", DestoryMethod.class);
		
		//反向控制 set注入
//		Computer computer = ac.getBean("computer", Computer.class);
//		computer.run();
//		Student student = ac.getBean("student", Student.class);
//		student.run();
		//集合注入
		//CollectionDemo friends = ac.getBean("friends", CollectionDemo.class);
		//friends.run();

		//构造器注入
//		ConstructorDemo phone = ac.getBean("phone", ConstructorDemo.class);
//		phone.run();
		
		//注解创建对象测试
		//ComponentDemo component = ac.getBean("componentDemo", ComponentDemo.class);
		//component.run();
		
		//注解注入对象
		//ResourceDemo Resource = ac.getBean("resourceDemo", ResourceDemo.class);
		//Resource.run();
		
		//注解注入spring表达式
		ValuleDemo value = ac.getBean("valuleDemo", ValuleDemo.class);
		value.run();
	}

}
