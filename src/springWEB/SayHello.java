package springWEB;

public class SayHello {
	private String hello = null;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
	public void springWEBHello(){
		System.out.println(hello);
	}
}
