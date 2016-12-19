package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.HandleConnection;

public class Insert {
	public static void addOne(String tableName, String name, float salary, int age){
		try {
			Connection conn = HandleConnection.getConnection();
			String sql = "insert " + tableName + " values(null, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, salary);
			ps.setInt(3, age);
			boolean success = ps.executeUpdate() == 1;
			if(success){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HandleConnection.closeConnection();
		}
	}
//	public static void main(String[] args){
//		addOne("employee", "wang", 22, 11);
//	}
}
