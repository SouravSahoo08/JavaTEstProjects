package _ATM_interface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Create_Account implements random {
	private int user_pin;
	private String password;
	private String name;
	private long Acc_no;
	private double Balance;

	public Create_Account() throws IOException {
		CentralClass.loadPropertyFile();
		System.out.println("--------Welcome new user!!--------");
	}

	Scanner sc = new Scanner(System.in);

	@Override
	// get new login details from the user
	public void get_login_details() {
		System.out.print("\nEnter a new 4 digit pin :");
		user_pin = sc.nextInt();
		System.out.print("\nEnter a new password :");
		password = sc.next().trim();

		sc.nextLine();

		System.out.print("\nEnter your name :");
		name = sc.nextLine().trim();
		System.out.print("\nEnter your 12 digit account number :");
		Acc_no = sc.nextLong();

		System.out.print("\nNet Balance in your account :");
		Balance = sc.nextDouble();
		UpdateDB(user_pin, password, name, Acc_no, Balance);
	}

	// Update Database
	public void UpdateDB(int pin, String pwd, String name, long AccNo, double Bal) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = CentralClass.connectDB();
			stmt = conn.createStatement();
			try {
				String Login_sql = "INSERT INTO Login VALUES (" + pin + ",'" + pwd + "')";
				stmt.executeUpdate(Login_sql);
				String Accounts_sql = "INSERT INTO Accounts (User_pin,Acc_No,Name,Balance,deposit,withdraw)VALUES "
						+ "(" + pin + "," + AccNo + ",'" + name + "'," + Bal + ", 0 , 0)";
				stmt.executeUpdate(Accounts_sql);
				System.out.println("Account updated");
			} catch (Exception e) {
				CentralClass.primaryKeyDuplicateError(pin, stmt);
				get_login_details();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CentralClass.closeDBConnection(stmt, conn);
		}

	}

	public static void main(String[] args) throws IOException {
		Create_Account obj = new Create_Account();
		obj.get_login_details();
	}
}
