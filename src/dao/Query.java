package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;
import entity.Employees;
import util.HandleConnection;

public class Query {
	@SuppressWarnings("finally")
	public static List<Employees> findAll(String tableName){
		List<Employees> data = new ArrayList<Employees>();
		Connection conn = HandleConnection.getConnection();
		String sql = "select * from " + tableName;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
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
			HandleConnection.closeConnection();
			return data;
		}
	}
	@SuppressWarnings("finally")
	public static Employees findById(String tableName, int id){
		Employees emp = new Employees();
		try {
			Connection conn = HandleConnection.getConnection();
			String sql = "select * from " + tableName + " where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				emp.setId(id);
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				emp.setAge(rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HandleConnection.closeConnection();
			return emp;
		}
	}
	
	@SuppressWarnings("finally")
	public static Admin findByAccount(String tableName, String account){
		Admin admin = new Admin();
		try {
			Connection conn = HandleConnection.getConnection();
			String sql = "select * from " + tableName + " where account = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				admin.setId(rs.getInt("id"));
				admin.setAccount(rs.getString("account"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			HandleConnection.closeConnection();
			return admin;
		}
	}
//	public static void main(String[] args){
//		List<Employees> list = findAll("employee");
//		String str = "";
//		for(int i = 0; i < list.size(); i++){
//			int id = list.get(i).getId();
//			String name = list.get(i).getName();
//			float salary = list.get(i).getSalary();
//			int age = list.get(i).getAge();
//			str += "id= " + id + "name= " + name + "salary= " + salary + "age= " + age;
//		}
//		System.out.println(str);
//		
//	}
}
