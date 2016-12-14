package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employees;

public class Query {
	@SuppressWarnings("finally")
	public static List<Employees> findAll(String tableName){
		List<entity.Employees> data = new ArrayList<Employees>();
		Connection conn = util.HandleConnection.getConnection();
		String sql = "select * from ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tableName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employees emp = new Employees();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				emp.setAge(rs.getInt("age"));
				data.add(emp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			util.HandleConnection.closeConnection();
			return data;
		}
	}
	public static void main(String[] args){
		List<Employees> list = findAll("employee");
		String str = "";
		for(int i = 0; i < list.size(); i++){
			int id = list.get(i).getId();
			String name = list.get(i).getName();
			float salary = list.get(i).getSalary();
			int age = list.get(i).getAge();
			str += "id= " + id + "name= " + name + "salary= " + salary + "age= " + age;
		}
		System.out.println(str);
		
	}
}
