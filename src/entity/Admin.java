package entity;

public class Admin {
	private static int id;
	private static String account;
	private static String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Admin.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		Admin.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Admin.password = password;
	}

}
