package springAOP;

import org.springframework.stereotype.Component;

@Component
public class Calc implements CalcImplment{

	@Override
	public int add(int i, int j) {
		return i + j;
	}

	@Override
	public int minus(int i, int j) {
		return i - j;
	}
	
}
