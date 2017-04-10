package springHibernateDao;

public interface BooksDao {
<<<<<<< HEAD
	public int findBookPriceByIsbn(String isbn);
	
	public void updateBooksStock(String isbn);
	
	public void updateUserAccount(String username, int price);
=======
	public float findBookPriceByIsbn(String isbn);
	
	public void updateBooksStock(String isbn);
	
	public void updateUserAccount(String username, float price);
>>>>>>> 7fa15766e702bf609a9a4c45886018235d4f9839
}
