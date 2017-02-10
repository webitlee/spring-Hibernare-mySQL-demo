package springAffair;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyImpl implements Buy {
	@Resource
	private BooksImpl bookshop;

	@Transactional
	@Override
	public void shopping(int userId, int bookId) {
		//查询单价
		double price = bookshop.query(bookId);
		//更新库存
		bookshop.updateQuantity(bookId);
		//更新余额
		bookshop.updateBalance(userId, price);
	}

}
