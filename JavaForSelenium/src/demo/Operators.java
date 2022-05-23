package demo;

public class Operators {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		
		//artimetic opertaors
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a % b);
		System.out.println(a / b);
		
		//relational operators - returns boolean value
		System.out.println(a==b);
		System.out.println(a>b);
		System.out.println(a<b);
		System.out.println(a>=b);
		System.out.println(a<=b);
		System.out.println(a!=b);
		
		//logical operators - && || !
		//works between 2 boolean values
		//&& - true true - true , all other false
		//|| - false false - false , all other true
		//! - negation
		
		boolean x = true;
		boolean y = false;
		System.out.println(x&&y);
		System.out.println(x||y);
		System.out.println(!x);
		
		//incrememnt decrement operator , ++ , --
		System.out.println(a++);
		System.out.println(a--);
	}
}
