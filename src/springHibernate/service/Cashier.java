package springHibernate.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class Cashier {
	@Resource
	private BooksService booksService;
	
	public void checkOut(String username, List<String> isbns){
		for(String isbn : isbns){
			booksService.purchase(username, isbn);
		}
	}
}
