package springDemos;
public class Computer {
	private  String mainBord;
	private  String ram;
	private  String hdd;
	private  String cpu;
	public  void setMainBord(String mainBord) {
		this.mainBord = mainBord;
	}
	public  void setRam(String ram) {
		this.ram = ram;
	}
	public  void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public  void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public  void run(){
		System.out.println("你的电脑配置为：" + mainBord + "," + ram + "," + hdd + "," + cpu);
	}
	
}
