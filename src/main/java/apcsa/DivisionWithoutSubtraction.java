package apcsa;
import java.util.Scanner;
public class DivisionWithoutSubtraction {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int counter = 0;	
		while (num1 - num2 > 0) {
			num1 = num1 - num2;
			counter++;
		}
		System.out.print(counter + ".");
		int temp = 0;
		int i = 0;
		while (i < 10) {
			num1 *= 10;
			while (num1 - num2 > 0) {
				num1 = num1 - num2;
				temp++;
			}
			System.out.print(temp);
			temp = 0;
			i++;
		}
	}
}