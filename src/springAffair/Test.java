package springAffair;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		String url = "applicationContext.xml";
		int bookId = 1;
		int memberId = 2;
		ApplicationContext ac = new ClassPathXmlApplicationContext(url);
		BooksImpl booksImpl = ac.getBean("bookshop", BooksImpl.class);
		Buy buy = ac.getBean("buyImpl", Buy.class);
		buy.shopping(memberId, bookId);
		//double price = booksImpl.query(bookId);
		//System.out.println(price);
		//booksImpl.updateQuantity(bookId);
		//booksImpl.updateBalance(memberId, price);
	}

}
