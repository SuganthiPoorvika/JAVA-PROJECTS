package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BillingDatabase {
	private String URL = "jdbc:mysql://localhost:3306/billing_app";
	private String USERNAME = "root";
	private String PASSWORD = "MoonGirl123*#@";
	Connection con;
	Statement st;
	String query;
	Scanner sc;

	BillingDatabase() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public void login(BillingData userdata) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\n Enter the username =");
		String name = sc.next();
		System.out.println("\n Enter the password =");
		String p = sc.next();
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select*from user_data where USER_NAME='" + name + "' and PASSWORD='" + p + "';");
		if (rs.next()) {
			System.out.println("\n succesful login");
		} else {
			System.out.println("Invalid user name and password");
			this.login(userdata);
		}
	}

}
