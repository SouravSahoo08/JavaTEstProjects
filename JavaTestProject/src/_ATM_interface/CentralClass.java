package _ATM_interface;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

interface random {
	void get_login_details() throws IOException;
}

public class CentralClass {
	static FileReader reader;
	static Properties propFile;

	protected static void loadPropertyFile() throws IOException {
		reader = new FileReader(
				"C:\\Users\\jacky\\git\\TestProjectRepository\\JavaTestProject\\src\\_ATM_interface\\config.Properties");
		propFile = new Properties();
		propFile.load(reader);
	}
	
	//Handles error for primary key duplicacy
	protected static void primaryKeyDuplicateError(int pin, Statement stmt) throws SQLException {
		System.out.println("account cannot be updated");

		String sql = "SELECT User_Pin FROM Login WHERE User_Pin = " + "'" + pin + "'";
		ResultSet rs = stmt.executeQuery(sql);

		int pin_txt = 0;

		while (rs.next()) {
			pin_txt = rs.getInt("User_pin");
		}

		if (pin == pin_txt)
			System.out.println("This pin already exist try another one..");
	}

	// opens the Database connection
	protected static Connection connectDB() throws SQLException {
		Connection conn;
		String URL = propFile.getProperty("url_ATM");
		String USER = propFile.getProperty("user");
		String PWD = propFile.getProperty("pwd");
		conn = DriverManager.getConnection(URL, USER, PWD);
		return conn;
	}

	// closes the Database connection
	protected static void closeDBConnection(Statement stmt, Connection conn) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
