package apcsa;
import java.util.Scanner;
public class ReverseInt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while (x > 0) {
			int temp = x % 10;
			x = x / 10;
			System.out.print(temp + "");
		}
	}
}