package springHibernate.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import springHibernateDaoImpl.BooksDaoImpl;

@Service
public class BooksService {
	
	@Resource
	private BooksDaoImpl booksDaoImpl;
	public void purchase(String username, String isbn){
		int price = booksDaoImpl.findBookPriceByIsbn(isbn)
	}
}
