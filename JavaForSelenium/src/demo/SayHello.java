package demo;

import java.util.Scanner;

public class SayHello {
	Scanner sc = new Scanner(System.in);
	public  void greet() {

		System.out.println("Enter Your name");
		String name = sc.nextLine();
		System.out.println("Hello " + name);
	}
	
	public  void sum() {
		System.out.println("Enter num1");
		int num1 = sc.nextInt();
		System.out.println("Enter num2");
		int num2 = sc.nextInt();
		System.out.println(num1+num2);
		
	}

	public void swap() {
		System.out.println("Enter num1");
		int num1 = sc.nextInt();
		System.out.println("Enter num2");
		int num2 = sc.nextInt();
		System.out.println("num1 and num2 before swapping "+num1+" "+num2);
		int temp = num1;
		num1=num2;
		num2=temp;
		System.out.println("num1 and num2 after swapping "+num1+" "+num2);
	}
	public static void main(String[] args) {
		SayHello obj = new SayHello();
		obj.greet();
		obj.sum();
		obj.swap();
	}

}
