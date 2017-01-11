package springDemos;

public class Student {
	private String name;
	private Computer computer;
	private ConstructorDemo phone;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void setPhone(ConstructorDemo phone) {
		this.phone = phone;
	}

	public void run(){
		System.out.println("学生姓名：" + name);
		computer.run();
		phone.run();
	}
}
