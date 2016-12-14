package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class HandleConnection {
	private static ThreadLocal<Connection> tl;
	private static BasicDataSource dataSource;
	static{
		try {
			Properties prop = new Properties();
			InputStream in = HandleConnection.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(in);
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(prop.getProperty("driver"));
			dataSource.setUrl(prop.getProperty("url"));
			dataSource.setUsername(prop.getProperty("username"));
			dataSource.setPassword(prop.getProperty("password"));
			dataSource.setInitialSize(Integer.parseInt(prop.getProperty("initialSize")));
			dataSource.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
			dataSource.setMaxWaitMillis(Integer.parseInt(prop.getProperty("maxWait")));
			dataSource.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
			dataSource.setMinIdle(Integer.parseInt(prop.getProperty("minIdle")));
			in.close();
			tl = new ThreadLocal<Connection>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("finally")
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			tl.set(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			return conn;
		}
		
	}
	public static void closeConnection(){
		Connection conn = tl.get();
		if(conn != null){
			try {
				conn.close();
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
