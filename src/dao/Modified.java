package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.HandleConnection;

public class Modified {
	public static void modifiedById(String tableName, int id, String name, float salary, int age){
		try {
			Connection conn = HandleConnection.getConnection();
			String sql = "update " + tableName + " set name=?, salary=?, age=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setFloat(2, salary);
			ps.setInt(3, age);
			ps.setInt(4, id);
			boolean success = ps.executeUpdate() == 1;
			if(success){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HandleConnection.closeConnection();
		}
	}
//	public static void main(String[] args){
//		modifiedById("employee", 11, "俩眼啊", 100, 100);
//	}
}
