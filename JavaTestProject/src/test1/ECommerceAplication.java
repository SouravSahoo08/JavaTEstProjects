package test1;


import java.util.ArrayList;
import java.util.List;
//q) Write a program to create user defined exception for a e-commerce application?
import java.util.Scanner;

class InvalidCardNumber extends RuntimeException {

	public InvalidCardNumber(String s) {
		super(s);
	}

}

class Database{
	List<String> card = List.of("12345","987654","129009",
									"984198312","9038102");
	List<String> database = new ArrayList<>(card);
}
public class ECommerceAplication {

	public static void main(String[] args) {
		System.out.println("-------------- PAYMENT PAGE ---------------");

		Scanner sc = new Scanner(System.in);
		Database ob = new Database();
	
		System.out.print("enter card number : ");
		String cNo = sc.next();

		if (!ob.database.contains(cNo)) 
			throw new InvalidCardNumber("you have entered a wrong card number");
		else
			System.out.println("order placed\nThanks for purchasing with us");
		
	}

}