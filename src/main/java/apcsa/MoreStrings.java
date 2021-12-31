package apcsa;

public class MoreStrings {
	public static void main(String[] args) {
		String s = "Mississippi";
		
		char[] arr = s.toCharArray();
		
		int counter = 0;
		int j = 0;
		int [] spos = new int[s.length()];
		
		for (int i = 0; counter != 3; i++) {
			if (arr[i] == 's') {
				counter++;
				spos[j] = i;
				j++;
			}
		}
		
		System.out.println(spos[2]);
		
	}
}
