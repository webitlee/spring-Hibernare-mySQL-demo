package springHibernateDao;

public interface BooksDao {
	public int findBookPriceByIsbn(String isbn);
	
	public void updateBooksStock(String isbn);
	
	public void updateUserAccount(String username, int price);
}
