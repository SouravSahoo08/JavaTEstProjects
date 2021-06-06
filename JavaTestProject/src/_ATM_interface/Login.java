package _ATM_interface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Scanner;

public class Login implements random {
	private int user_pin;
	private String password;

	public Login() throws IOException {
		CentralClass.loadPropertyFile();
	}

	public void get_login_details() {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter your pin : ");
		user_pin = sc.nextInt();
		System.out.print("\nenter your password : ");
		password = sc.next().trim();
		sc.close();
		check_Credentials(user_pin, password);
	}

	void check_Credentials(int pin, String pass) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = CentralClass.connectDB();
			stmt = conn.createStatement();

			String sql = "SELECT User_Pin,Pwd FROM Login WHERE User_Pin = " + "'" + pin + "'";
			ResultSet rs = stmt.executeQuery(sql);

			int pin_txt = 0;
			String pwd_txt = null;
			while (rs.next()) {
				pin_txt = rs.getInt("User_pin");
				pwd_txt = rs.getString("Pwd").trim();
			}

			if (pin == pin_txt && pass.equals(pwd_txt))
				System.out.println("welcome");
				/* 
				 * further proceedings to be written  
				 */
			else
				System.out.println("credentials don't match..");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CentralClass.closeDBConnection(stmt, conn);
		}
	}

	public static void main(String[] args) throws IOException {
		Login user1 = new Login();
		user1.get_login_details();
	}
}