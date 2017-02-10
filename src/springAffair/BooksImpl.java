package springAffair;


import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookshop")
public class BooksImpl implements Books {
	@Resource
	private JdbcTemplate jdbc;

	@Override
	public double query(int id) {
		String sql = "select price from books where id = ?";
		double price = jdbc.queryForObject(sql, Double.class, id);
		return price;
	}

	@Override
	public void updateQuantity(int id) {
		//检查库存是否充足，不足时抛异常
		String sql2 = "select quantity from books where id = ?";
		int quantity = jdbc.queryForObject(sql2, Integer.class, id);
		if(quantity <= 0){
			try {
				throw new QuantityException("库存不足");
			} catch (QuantityException e) {
				e.printStackTrace();
			}
		}
		
		String sql = "update books set quantity = quantity - 1 where id = ?";
		jdbc.update(sql, id);
	}

	@Override
	public void updateBalance(int id, double price) {
		//检查余额是否充足，不充足报异常
		String sql2 = "select balance from member where id = ?";
		int balance = jdbc.queryForObject(sql2, Integer.class, id);
		if(balance < price){
			try {
				throw new PriceException("余额不足");
			} catch (PriceException e) {
				e.printStackTrace();
			}
		}
		String sql = "update member set balance = balance - ? where id = ?";
		jdbc.update(sql, price, id);
	}

}
