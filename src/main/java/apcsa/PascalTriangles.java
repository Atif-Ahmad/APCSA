package apcsa;

import java.util.Scanner;

public class PascalTriangles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int [] arr1 = {1,1};
		System.out.println("1");
		System.out.println("1 1");
		

		for (int i = 2; i <= num; i++) {
			int [] arr2 = new int[i + 1];
			for (int j = 0; j < arr1.length; j++) {
				if (j == 0) {
					arr2[j] = 1;
				}else {
					arr2[j] = arr1[j-1] + arr1[j];
				}
				
			}
			
			
			arr2[arr2.length-1] = 1;
			for (int x : arr2) {
				System.out.print(x + " ");
			}
			arr1=arr2;
			System.out.println();
		}
		
		
	}
}