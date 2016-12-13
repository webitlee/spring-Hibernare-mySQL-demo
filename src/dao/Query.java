package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Query {
   public List<Connection> Query(String dbName, int id){
	   List<Connection> data = new ArrayList();
	   Connection conn = util.HandleConnection.getConnection();
	   String sql = "select * from ? where id = ?";
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ps.setString(1, dbName);
	   ps.setInt(2, id);
	   ResultSet rs = ps.executeQuery();
	   while(rs.next()){
		   data.add(rs.getRow());
	   }
	   return data;
   }
}
