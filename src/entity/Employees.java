package entity;

public class Employees {
	private static String name;
	private static float salary;
	private static int age;
	private static int id;
	public static int getId(){
		return id;
	}
	public static int setId(int id){
		return Employees.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Employees.name = name;
	}
	public static float getSalary() {
		return salary;
	}
	public static void setSalary(float salary) {
		Employees.salary = salary;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Employees.age = age;
	}
	
}
