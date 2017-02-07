package springAOP;

import org.springframework.stereotype.Component;

@Component
public class Calc {
	public int add(int a, int b){
		return a + b;
	}
	public int minus(int a, int b){
		return a - b;
	}
}
