package apcsa;

import java.util.Scanner;

public class PrintNums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			for (int j = x; j > 0; j--) {
				if (j-i > 0) {
					System.out.print(" ");
				}else {
					System.out.print(i);
				}
			}

			System.out.println(" ");
		}
	}

}
