package springDemos;

public class ConstructorDemo {
	private String cpu;
	private String ram;
	public ConstructorDemo(String cpu, String ram){
		this.cpu = cpu;
		this.ram = ram;
	}
	public void run(){
		System.out.println("您的手机配置为：cpu" + cpu + " ,内存：" + ram);
	}
}
