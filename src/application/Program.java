package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account datails: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Opening balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdrawal limit: ");
		double withdrawLimit = sc.nextDouble();
		Account ac = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter a withdrawal amount: ");
		double amount = sc.nextDouble();
		try {
			
			ac.withdraw(amount);
			System.out.printf("New balance: %.2f%n", ac.getBalance());
			
		} catch (BusinessException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		sc.close();

	}

}
