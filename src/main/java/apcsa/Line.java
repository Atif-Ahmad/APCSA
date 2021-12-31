package apcsa;

import java.util.Scanner;

public class Line {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double x1;
		double y1;

		double x2;
		double y2;

		System.out.println("Enter first x point");
		x1 = sc.nextDouble();
		sc.nextLine();

		System.out.println("Enter first y point");
		y1 = sc.nextDouble();
		sc.nextLine();

		System.out.println("Enter second x point");
		x2 = sc.nextDouble();
		sc.nextLine();

		System.out.println("Enter second y point");
		y2 = sc.nextDouble();
		sc.nextLine();
		
		double slope = (y2-y1)/(x2-x1);
		
		// y1 = slope * x1 + b
		double yInt = y1 - slope*x1;
		
		System.out.println("y = " + slope+ "x + " + yInt);
		
		
	}

}
