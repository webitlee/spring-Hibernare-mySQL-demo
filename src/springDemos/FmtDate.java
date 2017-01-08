package springDemos;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FmtDate {

	public static void main(String[] args) {
		String url = "applicationContext.xml";
		@SuppressWarnings("resource")
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(url);
		Date date = ac.getBean("date", Date.class);
		//System.out.println(date);
		Calendar calendar = ac.getBean("calendar", Calendar.class);
		//System.out.println(calendar);
		Date time = ac.getBean("time", Date.class);
		//System.out.println(time);
		InitMethod init = ac.getBean("init", InitMethod.class);
		DestoryMethod destroy = ac.getBean("destory", DestoryMethod.class);
		ac.close();
	}

}
