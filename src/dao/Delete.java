package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.HandleConnection;

public class Delete {
	public static void deleteOne(String tableName, int id){
		try {
			Connection conn = HandleConnection.getConnection();
			String sql = "delete from " + tableName + " where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			boolean success = ps.executeUpdate() == 1;
			if(success){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HandleConnection.closeConnection();
		}
	}
//	public static void main(String[] args){
//		deleteOne("employee", 10);
//	}
}
