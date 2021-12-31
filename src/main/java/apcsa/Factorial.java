package apcsa;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		int res = 1;

		if (x == 0 || x == 1) {
			System.out.println(res);
		} else {
			for (int i = x; i > 0; i--) {
				res *= i;
			}
			System.out.println(res);
		}
		
	}
}
