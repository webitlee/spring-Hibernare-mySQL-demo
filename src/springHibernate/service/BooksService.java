package springHibernate.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import springHibernateDaoImpl.BooksDaoImpl;

@Service
public class BooksService {
	
	@Resource
	private BooksDaoImpl booksDaoImpl;
	public void purchase(String username, String isbn){
<<<<<<< HEAD
		int price = booksDaoImpl.findBookPriceByIsbn(isbn)
=======
		float price = booksDaoImpl.findBookPriceByIsbn(isbn);
		booksDaoImpl.updateBooksStock(isbn);
		booksDaoImpl.updateUserAccount(username, price);
>>>>>>> 7fa15766e702bf609a9a4c45886018235d4f9839
	}
}
