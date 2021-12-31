package apcsa;

public class BubbleSort {

	public static void main(String[] args) {
//		int[] x = { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int[] x = { 1,3,2,4,5,6,7,8,9,10,11,12,13,14,15 };
		
		sort(x);
		
		for (int i : x) {
			System.out.print(i + " ");
		}
		

		
	}
	
	public static int[] sort(int [] x) {
		for (int i = 0; i < x.length; i++) {
			int counter = 0;
			for (int j = i+1; j < x.length; j++) {
				if (x[i] > x[j]) {
					counter ++;
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
			
			if (x[0] < x[1] && x[1] < x[2] && x[2] < x[3] && x[3] < x[4] && x[4] < x[5] 
					&& x[5] < x[6] && x[6] < x[7] && x[7] < x[8] && x[8] < x[9] && x[9] < x[10]
							&& x[10] < x[11] && x[11] < x[12] && x[12] < x[13] && x[13] < x[14]) {
				return x;
			}
			
		}

		return x; 
	}

}
