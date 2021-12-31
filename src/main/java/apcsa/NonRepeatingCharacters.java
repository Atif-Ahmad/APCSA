package apcsa;

import java.util.*;

public class NonRepeatingCharacters {

	public static String NonrepeatingCharacter(String str) {
		char[] temp = str.toCharArray();
		

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (i != j && i < temp.length && j < temp.length) {
					if (temp[i] != temp[j]) {
						
					} else {
						temp = remove(temp[i], temp);
						continue;
					}
				}
			}
		}

		// code goes here
		String res = "";
		for (char c : temp) {
			res += c;
		}
		return res;
	}

	public static char[] remove(char x, char[] arr) {
		ArrayList<Character> newArr = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != x) {
				newArr.add(arr[i]);
			}
		}

		char[] res = new char[newArr.size()];

		for (int i = 0; i < newArr.size(); i++) {
			res[i] = newArr.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.print(NonrepeatingCharacter("heaven can wait"));
		
	}

}