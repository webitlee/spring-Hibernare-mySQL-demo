package springHibernate;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	private static ApplicationContext ac = null;
	public static void main(String[] args) throws SQLException {
		ac = new ClassPathXmlApplicationContext("applicationContextSpringHibernate.xml");
		DataSource dataSource = ac.getBean("dataSource", DataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
