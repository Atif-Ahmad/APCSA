package apcsa;

import java.util.Scanner;

public class EvenlySpaced {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int x3 = sc.nextInt();
		
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		
		if (x1 < x2 && x2 < x3) {
			temp1 = x1;
			temp2 = x2;
			temp3 = x3;
		}else if (x1 > x2 && x2 > x3) {
			temp1 = x3;
			temp2 = x2;
			temp3 = x1;
		}else if(x2 < x1 && x1 < x3) {
			temp1 = x2;
			temp2 = x1;
			temp3 = x3;
		}else if (x3 < x1 && x2 > x1) {
			temp1 = x3;
			temp2 = x1;
			temp3 = x2; 
		}else if (x3 < x2 && x1 < x3) {
			temp1 = x1;
			temp2 = x3;
			temp3 = x2;
		}else if (x2 < x3 && x1 > x3) {
			temp1 = x2;
			temp2 = x3;
			temp3 = x1;
		}
		
		if (temp3 - temp2 == temp2 - temp1) {
			System.out.println("Evenly spaced");
		}else {
			System.out.println("not evenly spaced");
		}
		

	}
}
