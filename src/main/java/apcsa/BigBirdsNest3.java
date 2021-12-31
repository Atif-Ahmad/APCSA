package apcsa;

import java.util.Scanner;

public class BigBirdsNest3 {
	public static void main(String[] args) {
		Scanner andrew = new Scanner(System.in);
		System.out.println("Enter a positive integer");
		int x = andrew.nextInt();
		
		for (int i = 0; i < x; i++) {
			int numStars = 2 * x - 1; //7
			for (int j = 0; j < numStars; j++) {
				if (numStars-j > x+i || numStars - j < x-i) {
					System.out.print(" ");
					
				}else {
					System.out.print("x");
				}
			}
			System.out.println(" ");
		}
	}
}
