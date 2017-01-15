package springDemos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ValuleDemo {
	@Value("#{conf.userName}")
	private String userName;
	@Value("#{conf.passWord}")
	private String passWord;
	
	public void run(){
		System.out.println("这里用来测试@Value注解注入spring表达式：");
		System.out.println("前提是在applicationContex.xml文件中创建properties属性文件");
		System.out.println("用户名：" + userName);
		System.out.println("密码：" + passWord);
	}
	
}
