package _ATM_interface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class demo {

	static FileReader reader;
	static Properties propFile;

	public demo() throws FileNotFoundException {
		reader = new FileReader(
				"C:\\Users\\jacky\\git\\TestProjectRepository\\JavaTestProject\\src\\_ATM_interface\\config.Properties");
		propFile = new Properties();
	}

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {

			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			new demo();
			propFile.load(reader);
			String URL = propFile.getProperty("url");
			String USER = propFile.getProperty("user");
			String PWD = propFile.getProperty("pwd");

			System.out.println("opening connection");
			
			conn = DriverManager.getConnection(URL, USER, PWD);
			stmt = conn.createStatement();
			/*
			 * String sql = "SELECT * FROM DemoTable"; ResultSet rs =
			 * stmt.executeQuery(sql);
			 * 
			 * while (rs.next()) { String name = rs.getString("Name"); int Age =
			 * rs.getInt("Age"); String Branch = rs.getString("Branch");
			 * System.out.println("name :" + name); System.out.println("Age :" + Age);
			 * System.out.println("Branch :" + Branch); }
			 * 
			 * System.out.println("------changing name------- ");
			 * 
			 * sql = "INSERT INTO DemoTable VALUES ('ABC',19,'cst')";
			 * stmt.executeUpdate(sql); System.out.println("table updated");
			 */
			Scanner sc = new Scanner(System.in);
			String check = sc.nextLine();
			String sql = "SELECT Name FROM DemoTable WHERE Name = " + "'" + check + "'";
			ResultSet chk = stmt.executeQuery(sql);
			
			String cmp_str = "";
			while (chk.next()) {
				cmp_str = chk.getString("Name").trim();
			}

			if (check.equals(cmp_str))
				System.out.println("true");
			else
				System.out.println("false");

			/*
			 * while (rs.next()) { String name = rs.getString("Name"); int Age =
			 * rs.getInt("Age"); String Branch = rs.getString("Branch");
			 * System.out.println("name :" + name); System.out.println("Age :" + Age);
			 * System.out.println("Branch :" + Branch); }
			 */

			chk.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
