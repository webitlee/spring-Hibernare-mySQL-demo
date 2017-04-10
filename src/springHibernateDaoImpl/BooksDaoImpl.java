package springHibernateDaoImpl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import springHibernate.exception.PriceException;
import springHibernate.exception.QuantityException;
import springHibernateDao.BooksDao;

@Repository
public class BooksDaoImpl implements BooksDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	//获取和当前线程绑定的Session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	} 

	@Override
<<<<<<< HEAD
	public int findBookPriceByIsbn(String isbn) {
		String hql = "select b.price from Books b where b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (Integer)query.uniqueResult();
=======
	public float findBookPriceByIsbn(String isbn) {
		String hql = "select b.price from Books b where b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (Float)query.uniqueResult();
>>>>>>> 7fa15766e702bf609a9a4c45886018235d4f9839
	}

	@Override
	public void updateBooksStock(String isbn) {
		//检查库存是否充足
		String hql2 = "select b.stock from Books b where b.isbn = ?";
		int stock = (int)getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
		if(stock <= 0){
			throw new QuantityException("库存不足");
		}
		String hql = "update Books b set b.stock = b.stock - 1 where b.isbn = ?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
	}

	@Override
<<<<<<< HEAD
	public void updateUserAccount(String username, int price) {
		//检查余额是否充足
		String hql2 = "select a.balance from Account a where a.username = ?";
		float balance = (float) getSession().createQuery(hql2).setString(0, username).uniqueResult();
		if(balance <= 0 ){
			throw new PriceException("余额不足");
		}
		String hql = "update Account a set a.balance = a.balance - ? where a.username = ?";
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
=======
	public void updateUserAccount(String username, float price) {
		//检查余额是否充足
		String hql2 = "select a.balance from Account a where a.username = ?";
		float balance = (float) getSession().createQuery(hql2).setString(0, username).uniqueResult();
		if(balance <= price ){
			throw new PriceException("余额不足");
		}
		String hql = "update Account a set a.balance = a.balance - ? where a.username = ?";
		getSession().createQuery(hql).setFloat(0, price).setString(1, username).executeUpdate();
>>>>>>> 7fa15766e702bf609a9a4c45886018235d4f9839
	}

}
