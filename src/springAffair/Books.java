package springAffair;

public interface Books {
	public double query(int id);
	public void updateQuantity(int id);
	public void updateBalance(int id, double price);
}
