package springJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class Test {
	private static String url = "applicationContext.xml";
	private static ApplicationContext ac = new ClassPathXmlApplicationContext(url);
	private static JdbcTemplate jdbc;
	private static NamedParameterJdbcTemplate namedJdbc;
	//更新数据表
	public static void update(){
		String sql = "update employee set name = ? where id = ?";
		jdbc.update(sql, "李亚楠", 1);
	}
	//批量插入数据表
	public static void insert(){
		String sql = "insert employee values(?, ?, ?, ?)";
		List<Object[]> args = new ArrayList<Object[]>();
		args.add(new Object[]{null, "李TEST", 520.11, 25});
		jdbc.batchUpdate(sql, args);
	}
	
	//查询一条数据表内容
	public static void query(){
		String sql = "select * from employee where id = ?";
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<Employees>(Employees.class);
		Employees emp = jdbc.queryForObject(sql, rowMapper, 1);
		System.out.println(emp);
	}
	
	//查询一组数据表内容
	public static void queryList(){
		String sql = "select * from employee limit 3";
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<Employees>(Employees.class);
		List<Employees> emps = jdbc.query(sql, rowMapper);
		System.out.println(emps);
	}
	
	//使用NamedParameterJdbcTemplate插入数据,可以使用具名参数
	public static void testNamedParameterJdbcTemplate(){
		String sql = "insert employee values(:id, :name, :salary, :age)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", null);
		paramMap.put("name", "Bluse Lee");
		paramMap.put("salary", 12000);
		paramMap.put("age", 23);
		namedJdbc.update(sql, paramMap);
	}
	
	public static void testNamedParameterJdbcTemplate2(){
		String sql = "insert employee values(:id, :name, :salary, :age)";
		Employees emps = new Employees();
		emps.setId(null);
		emps.setName("xxoo");
		emps.setSalary(1234);
		emps.setAge(12);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(emps);
		namedJdbc.update(sql, paramSource);
	}
	
	public static void main(String[] args) throws SQLException{
		BasicDataSource dataSource = ac.getBean("dataSource", BasicDataSource.class);
		System.out.println(dataSource.getConnection());
		jdbc = ac.getBean("jdbc", JdbcTemplate.class);
		namedJdbc = ac.getBean("namedJdbc", NamedParameterJdbcTemplate.class);
		//update();
		//insert();
		//query();
		//queryList();
		//testNamedParameterJdbcTemplate();
		testNamedParameterJdbcTemplate2();
		System.out.println("The end...");
	}
}
