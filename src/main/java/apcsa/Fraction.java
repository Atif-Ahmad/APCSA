package apcsa;

import java.util.Scanner;

public class Fraction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numerator1;
		int denominator1;
		
		int numerator2;
		int denominator2;
		
		System.out.println("Enter a numerator");
		numerator1 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter a denominator");
		denominator1 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter a second numerator");
		numerator2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter a second denominator");
		denominator2 = sc.nextInt();
		sc.nextLine();
		
		double numerator = numerator1 * denominator2 + numerator2 * denominator1;
		double denominator = denominator1 * denominator2;
		System.out.println("Sum: " + numerator + "/" + denominator);
		
		double subNum = (numerator1 * denominator2) - (numerator2 * denominator1);
		double subDen = (denominator1 * denominator2);
		System.out.println("Difference: " + subNum + "/" + subDen);
		
		double multNum = numerator1 * numerator2;
		double multDem = denominator1 * denominator2;
		System.out.println("Multiplication: " + multNum + "/" + multDem);
		
		double divNum = (numerator1 * denominator2);
		double divDen = (denominator1 * numerator2);
		System.out.println("Division: " + divNum + "/" + divDen);
		
		
		
	}
}
