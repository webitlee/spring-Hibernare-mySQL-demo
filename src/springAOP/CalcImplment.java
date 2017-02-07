package springAOP;

import org.springframework.stereotype.Component;

@Component
public interface CalcImplment {
	public int add(int i, int j);
	public int minus(int i , int j);
}
