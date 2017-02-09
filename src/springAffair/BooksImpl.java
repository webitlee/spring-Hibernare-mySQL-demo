package springAffair;

import java.util.ArrayList;
import java.util.List;

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
		String sql = "update books set quantity = quantity - 1 where id = ?";
		jdbc.update(sql, id);
	}

	@Override
	public void updateBalance(int id, double price) {
		String sql = "update member set balance = balance - ? where id = ?";
		jdbc.update(sql, price, id);
	}

}
