package myproject;

import java.sql.SQLException;
import java.util.Scanner;

public class BillingApp {
	BillingData bd;
	BillingDatabase bds;
	Scanner sc;
	public void showMenu() throws ClassNotFoundException, SQLException {
		System.out.println("\n1.Administrator login\n2.Biller login \n3.Stock keeper login");
		getUserOption();
	}
	public void getUserOption() throws ClassNotFoundException, SQLException {
		System.out.println("\n\t\tChoose your options");
		sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
		case 1:{
			bds=new BillingDatabase();
			bds.login(bd);
			adminRole();
			showMenu();
		}
		}
	}
	public void adminRole() {
		System.out.println("\n\n\t\t Admin Role");
	}
	


public static void main(String args[]) throws ClassNotFoundException, SQLException {
	BillingApp bd= new BillingApp();
	bd.showMenu();
	
}
}