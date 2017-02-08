package springAOP;

import org.springframework.stereotype.Component;

@Component
public class Calc implements CalcImplment{

	@Override
	public void add(int i, int j) {
		System.out.println(i + j);
	}

	@Override
	public void minus(int i, int j) {
		System.out.println(i - j);
	}

	@Override
	public int mod(int i, int j) {
		System.out.println(i % j);
		 return i % j;
	}

	@Override
	public int div(int i, int j) {
		System.out.println(i / j);
		return i / j;
	}
	
}
