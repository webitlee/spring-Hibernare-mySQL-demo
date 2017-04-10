package springHibernateDao;

public interface BooksDao {
	public float findBookPriceByIsbn(String isbn);
	
	public void updateBooksStock(String isbn);
	
	public void updateUserAccount(String username, float price);
}
