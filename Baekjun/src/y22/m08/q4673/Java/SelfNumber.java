package y22.m08.q4673.Java;

public class SelfNumber{}
class Dnum{
    public long d0 = 0;
    public long d1 = 0;
    public long d2 = 0;
    public long d3 = 0;
    public long d4 = 0;
    public long sum =0;
    
    long d(long N){
        if((N/10)<1){
            d0 = N/1;
            sum = d0+N;
            return sum;
        }else if((N/100)<1){
            d0 = N/1;
            d2 = N/10;
            sum = d0+d2+N;
            return sum;
        }else if((N/1000)<1){
            d0 = N/1;
            d1 = N/10;
            d2 = N/100;
            sum = d0+d1+d2+N;
            return sum;
        }else if((N/10000)<=1){
            d0 = N/1;
            d1 = N/10;
            d2 = N/100;
            d3 = N/1000;
            d4 = N/10000;
            sum = d0+d1+d2+d3+d4+N;
            return sum;
        }else {return sum;}
    }
  
    public static void main(String[] args) {
		long d = d(34);
	}
}
