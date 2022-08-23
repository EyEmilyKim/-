package y22.m08.app.polynomial;

public class Term {
	public int coef;//계수
	public int expo;//지수
	
	public Term(int c, int e) {
		coef = c;
		expo = e;
	}
	
	public int calc(int x) {
		return coef * (int)Math.pow(x, expo); 
	}
	
	public String toString() {
		return coef + "x^" + expo;
	}
}
