package apcsa;
import java.util.Scanner;
public class LeastCommonMultiple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int res = 0;
		if (x == 1) {
			res = y;
		} else if (y == 1) {
			res = x;
		} else {
			boolean foundLCM = false;
			if (x > y) {
				int i = 1;
				while (!foundLCM) {
					if (i % x == 0 && i % y == 0) {
						res = i;
						foundLCM = true;
					}
					i++;
				}
			} else if (x < y) {
				int i = 1;
				while (!foundLCM) {
					if (i % x == 0 && i % y == 0) {
						res = i;
						foundLCM = true;
					}
					i++;
				}
			} else {
				res = x;
			}
		}
		System.out.println(res);
	}
}