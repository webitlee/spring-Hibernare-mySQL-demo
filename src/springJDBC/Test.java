package springJDBC;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	private static String url = "applicationContext.xml";
	private static ApplicationContext ac = new ClassPathXmlApplicationContext(url);
	
	public static void main(String[] args) throws SQLException{
		BasicDataSource dataSource = ac.getBean("dataSource", BasicDataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
