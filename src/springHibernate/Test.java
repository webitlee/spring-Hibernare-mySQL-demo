package springHibernate;


import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springHibernate.service.BooksService;
import springHibernate.service.Cashier;

public class Test {
	private static ApplicationContext ac = null;
	private static BooksService booksService = null;
	private static Cashier cashier = null;
	public static void main(String[] args) throws SQLException {
		ac = new ClassPathXmlApplicationContext("applicationContextSpringHibernate.xml");
//		DataSource dataSource = ac.getBean("dataSource", DataSource.class);
//		System.out.println(dataSource.getConnection());
		
//		booksService = ac.getBean("booksService", BooksService.class);
//		booksService.purchase("aa", "1001");
		
		cashier = ac.getBean("cashier", Cashier.class);
		cashier.checkOut("aa", Arrays.asList("1001", "1002"));
	}
}
