package y22.m09.wrapper;

public class WrapperClass {
	public static void main(String[] args) {
		Integer num0 = new Integer(17);//박싱(자바v9에서 없어진 문법이라네)
		Integer num = 17;//오토박싱 
		int n = num.intValue(); //언박싱
		System.out.println(num);//17
		System.out.println((int)num);//17
		System.out.println(n);//17
	
		Character ch = 'Z';//오토박싱 : Character ch = new Character('X');
		char c = ch;//오토언박싱 : char c = ch.charValue();
		System.out.println(c +"\n");//Z
		
		
		Integer num1 = new Integer(10);
        Integer num2 = new Integer(20);
        Integer num3 = new Integer(10);
 
        System.out.println(num1 < num2);       // true
        System.out.println(num1 == num3);      // false
        System.out.println(num1.equals(num3)); // true
        //래퍼 클래스도 객체이므로 값 비교를 위해서는 equals()사용.
        //등가연산자(==)는 두 인스턴스의 값 비교가 아닌 두 인스턴스의 주소값을 비교한다.
        
        //근데 아래처럼 하면... 등가연산자로 비교가 돼버리네..
        //class는 Integer 로 나오긴 하는데... upcasting이 되는건가...?(TBC)
        Integer num01 = 10;
        Integer num02 = 20;
        Integer num03 = 10;
        System.out.println(num01 < num02);       // true
        System.out.println(num01 == num03);      // TRUE!
        System.out.println(num01.equals(num03)); // true
        System.out.println(num01.getClass());       //Integer
        
        Integer num001 = (Integer)10;
        Integer num002 = (Integer)20;
        Integer num003 = (Integer)10;
        System.out.println(num001 < num002);       // true
        System.out.println(num001 == num003);      // TRUE!
        System.out.println(num001.equals(num003)); // true
        System.out.println(num001.getClass());       //Integer
        
	}

}
