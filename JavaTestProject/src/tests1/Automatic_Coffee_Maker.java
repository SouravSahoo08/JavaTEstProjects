package tests1;

import java.util.Scanner;

public class Automatic_Coffee_Maker {
	static private String[] C = { "Espresso coffee", "Cappuccino Coffee", "Latte coffee", "spl coffee" };
	static private String[] T = { "plain tea", "Assam tea", "ginger tea", "cardamom tea", "masala tea", "lemon tea",
			"green tea", "Organic darjeeling tea" };
	static private String[] S = { "hot and sour", "veg corn", "tomato soup", "Spicy tomato soup" };
	static private String[] B = { "hot chocolate", "badam drink", "badam pista" };

	void m1() {
		System.out.println("kjnaeirng");
	}

	public static void main(String[] args) throws InterruptedException {
		welcome_Menu();

	}

	static Scanner in = new Scanner(System.in);

	public static void welcome_Menu() throws InterruptedException {
		String choice1 = null;
		System.out.println("-------WELCOME TO CCD!!--------");

		System.out.println("enter type of drink you want: ");

		choice1 = in.next().toLowerCase();

		switch (choice1) {
		case "c":
			Coffee();
			break;
		case "t":
			Tea();
			break;
		case "s":
			Soup();
			break;
		case "b":
			Bevarages();
			break;
		default:
			System.out.println("invalid choice");
			welcome_Menu();
		}
	}

	private static void Bevarages() throws InterruptedException {
		System.out.println("choose type of Bevarage from menu :");
		int ch = in.nextInt();
		if (ch > B.length || ch < 1) {
			System.out.println("invalid option");
			Bevarages();
		} else {
			System.out.println("enjoy your " + B[ch - 1]);
			System.out.println("Thank you\n\n============================\n\n");
			Thread.sleep(5000);
			welcome_Menu();
		}

	}

	private static void Soup() throws InterruptedException {
		System.out.println("choose type of Soup from menu :");
		int ch = in.nextInt();
		if (ch > S.length || ch < 1) {
			System.out.println("invalid option");
			Soup();
		} else {
			System.out.println("enjoy your " + S[ch - 1]);
			System.out.println("Thank you\n\n============================\n\n");
			Thread.sleep(5000);
			welcome_Menu();
		}

	}

	private static void Tea() throws InterruptedException {
		System.out.println("choose type of Tea from menu :");
		int ch = in.nextInt();
		if (ch > T.length || ch < 1) {
			System.out.println("invalid option");
			Tea();
		} else {
			System.out.println("enjoy your " + T[ch - 1]);
			System.out.println("Thank you\n\n============================\n\n");
			Thread.sleep(5000);
			welcome_Menu();
		}

	}

	private static void Coffee() throws InterruptedException {
		System.out.println("choose type of coffee from menu :");
		int ch = in.nextInt();
		if (ch > C.length || ch < 1) {
			System.out.println("invalid option");
			Coffee();
		} else {
			System.out.println("enjoy your " + C[ch - 1]);
			System.out.println("Thank you\n\n============================\n\n");
			Thread.sleep(5000);
			welcome_Menu();
		}
	}

}
