package springDemos;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ResourceDemo {
	//@Resource  //找id=computer的对象，没有则找类型为Computer
	@Resource(name="computer")   //直接找id=computer的对象
	private Computer computer;

	public void run(){
		System.out.println("我在这里使用注解的方式注入Computer对象,并调用其run方法");
		computer.run();
	}
}
