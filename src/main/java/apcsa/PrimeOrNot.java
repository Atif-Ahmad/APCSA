package apcsa;

import java.util.Scanner;

public class PrimeOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		
		
		if (x == 0 || x == 1) {
			System.out.println("Neither");
		}else if (x== 2) {
			System.out.println("Prime");
		}
		else if (x > 0){
			boolean isPrime = true;
			
			for (int i = 2; i < x; i++) {
				if (x % i == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime) {
				System.out.println("Prime");
			}else {
				System.out.println("Not Prime");
			}
			
		}else {
			boolean isPrime = true;
			for (int i = -2; i > x; i--) {
				if (x % i == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime) {
				System.out.println("Prime");
			}else {
				System.out.println("Not Prime");
			}
		}
	}

}
