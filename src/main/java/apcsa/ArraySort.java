package apcsa;

import java.util.Scanner;

public class ArraySort {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int num = sc.nextInt();
		
		int [] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			x[i] = sc.nextInt();
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = i+1; j < num ;j++) {
				if (x[i] > x[j]) {
					int temp = x[j];
					x[j] = x[i];
					x[i] = temp;
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
			System.out.print(x[i] + " ");
		}
		
		
		
	}

}
