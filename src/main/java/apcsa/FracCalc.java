package apcsa;

import java.util.Scanner;

public class FracCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 fractions");

		int[] fracArr = new int[4];
		for (int i = 0; i < 4; i++) {
			fracArr[i] = sc.nextInt();
		}

		int[] frac1 = { fracArr[0], fracArr[1] };
		int[] frac2 = { fracArr[2], fracArr[3] };

		System.out.println("What operation do you want to do? \n" + "1. Additon\n" + "2. Subtraction\n"
				+ "3. Multiplication\n" + "4. Division\n" + "5. Simplify a fraction");
		int choice = sc.nextInt();

		if (choice == 1) {
			int[] sum = add(frac1, frac2);
			System.out.println(sum[0] + "/" + sum[1]);
		} else if (choice == 2) {
			int[] diff = subtract(frac1, frac2);
			System.out.println(diff[0] + "/" + diff[1]);
		} else if (choice == 3) {
			int[] prod = mult(frac1, frac2);
			System.out.println(prod[0] + "/" + prod[1]);
		} else if (choice == 4) {
			int[] quot = div(frac1, frac2);
			System.out.println(quot[0] + "/" + quot[1]);
		} else if (choice == 5) {
			int[] s1 = simplify(frac1);
			int[] s2 = simplify(frac2);
			System.out.println(s1[0] + "/" + s1[1]);
			System.out.println(s2[0] + "/" + s2[1]);
		}
		
		System.out.println("Would you like to run again? \n \"Yes\" or \"No\"");
		String res = sc.next();
		while (res.equals("Yes")) {
			System.out.println("Enter 2 fractions");

			for (int i = 0; i < 4; i++) {
				fracArr[i] = sc.nextInt();
			}

			frac1 = new int[]{ fracArr[0], fracArr[1] };
			frac2 = new int[]{ fracArr[2], fracArr[3] };

			System.out.println("What operation do you want to do? \n" + "1. Additon\n" + "2. Subtraction\n"
					+ "3. Multiplication\n" + "4. Division\n" + "5. Simplify a fraction");
			choice = sc.nextInt();

			if (choice == 1) { 
				int[] sum = add(frac1, frac2);
				System.out.println(sum[0] + "/" + sum[1]);
			} else if (choice == 2) {
				int[] diff = subtract(frac1, frac2);
				System.out.println(diff[0] + "/" + diff[1]);
			} else if (choice == 3) {
				int[] prod = mult(frac1, frac2);
				System.out.println(prod[0] + "/" + prod[1]);
			} else if (choice == 4) {
				int[] quot = div(frac1, frac2);
				System.out.println(quot[0] + "/" + quot[1]);
			} else if (choice == 5) {
				int[] s1 = simplify(frac1);
				int[] s2 = simplify(frac2);
				System.out.println(s1[0] + "/" + s1[1]);
				System.out.println(s2[0] + "/" + s2[1]);
			}
			
			System.out.println("Would you like to run again? \n \"Yes\" or \"No\"");
			res = sc.next();
		}
		if (res.equals("No")) {
			System.out.println("Goodbye.");
		}

	}

	public static int[] add(int[] arr1, int[] arr2) {
		int numerator = (arr1[0] * arr2[1]) + (arr2[0] * arr1[1]);
		int denominator = arr1[1] * arr2[1];

		int finalarr[] = { numerator, denominator };

		return simplify(finalarr);

	}

	public static int[] subtract(int[] arr1, int[] arr2) {
		int numerator = (arr1[0] * arr2[1]) - (arr2[0] * arr1[1]);
		int denominator = arr1[1] * arr2[1];

		int finalarr[] = { numerator, denominator };

		return simplify(finalarr);

	}

	public static int[] mult(int[] arr1, int[] arr2) {
		int numerator = arr1[0] * arr2[0];
		int denominator = arr1[1] * arr2[1];

		int finalarr[] = { numerator, denominator };

		return simplify(finalarr);

	}

	public static int[] div(int[] arr1, int[] arr2) {
		int numerator = arr1[0] * arr2[1];
		int denominator = arr1[1] * arr2[0];

		int finalarr[] = { numerator, denominator };

		return simplify(finalarr);

	}

	public static int[] simplify(int arr[]) {
		int num = arr[0];
		int den = arr[1];

		if (num < 0 || den < 0) {
			for (int i = -1; i > num * den; i--) {
				if (num % i == 0 && den % i == 0) {
					num = num / -i;
					den = den / -i;
					i = -1;
				}
			}
		} else {

			for (int i = 1; i < num * den; i++) {
				if (num % i == 0 && den % i == 0) {
					num = num / i;
					den = den / i;
					i = 1;
				}
			}
		}

		arr[0] = num;
		arr[1] = den;

		return arr;
	}
}
