package apcsa;

import java.util.Scanner;

public class BigBirdsNest2 {
	
	public static void main(String[] args) {
		Scanner smaran = new Scanner(System.in);
		int x = smaran.nextInt();
		//cannot work for numbers < 3
		for (int i = 0; i < x; i++) {
			System.out.print("x");
		}
		for (int i = 0; i < x-1; i++) {
			for (int j = x-1; j > 0; j--) {
				if (j == i) {
					System.out.print("x");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
		for (int i = 0; i < x; i++) {
			System.out.print("x");
		}
	}

}
