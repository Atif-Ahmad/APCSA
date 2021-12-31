package apcsa;

import java.util.Scanner;

public class ConnectFour {

	static boolean didP1Win = false;
	static boolean didP2Win = false;
	static boolean isWin = false;

	static String[][] x = new String[6][7];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				x[i][j] = "_";
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}

		int a = 0;
		boolean b = didWin();
		while (!b && a < 42) {
			System.out.println("Player 1, Enter a column number, 1-7");
			int playerCol = sc.nextInt();
			placepiece(1, playerCol);
			print(x);

			b = didWin();

			a++;
			if (!b) {

				System.out.println("Player 2, Enter a column number, 1-7");
				int playerCol2 = sc.nextInt();
				placepiece(2, playerCol2);
				print(x);
				a++;

				b = didWin();
			}

		}

		if (didP1Win) {
			System.out.println("Nice Player 1");
		} else if (didP2Win) {
			System.out.println("Nice Player 2");
		} else {
			System.out.println("How'd you tie?");
		}

	}

	static void placepiece(int player, int playerCol) {
		for (int i = 0; i <= 6; i++) {
			boolean hasPlaced = false;
			if (i == playerCol-1) {
				int j = 0;
				while (!hasPlaced) {
					if (x[j + 1][i].equals("_") && j < 4) {
						j++;
					} else if (!x[j + 1][i].equals("_") && !x[j][i].equals("X") && !x[j][i].equals("O")) {
						if (player == 1) {
							x[j][i] = "X";
							hasPlaced = true;
							j++;
						} else {
							x[j][i] = "O";
							hasPlaced = true;
							j++;
						}
					} else if (j == 4) {
						if (player == 1) {
							x[j + 1][i] = "X";
							hasPlaced = true;
						} else {
							x[j + 1][i] = "O";
							hasPlaced = true;
						}
						j++;
					} else
						j++;

				}
			}
		}
	}

	static void print(String[][] x) {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean didWin() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (x[i][j].equals(x[i][j + 1]) && x[i][j + 1].equals(x[i][j + 2]) && x[i][j + 2].equals(x[i][j + 3])
						&& !x[i][j].equals("_")) {
					if (x[i][j].equals("X")) {
						didP1Win = true;
					} else if (x[i][j].equals("O")) {
						didP2Win = true;
					}
				}
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				if (x[j][i].equals(x[j + 1][i]) && x[j + 1][i].equals(x[j + 2][i]) && x[j + 2][i].equals(x[j + 3][i])
						&& !x[j][i].equals("_")) {
					if (x[j][i].equals("X")) {
						didP1Win = true;
					} else if (x[j][i].equals("O")) {
						didP2Win = true;
					}
				}
			}
		}

		for (int i = 5; i >= 3; i--) {
			for (int j = 0; j < 2; j++) {
				if (x[i][j].equals(x[i - 1][j + 1]) && x[i - 1][j + 1].equals(x[i - 2][j + 2])
						&& x[i - 2][j + 2].equals(x[i - 3][j + 3]) && !x[i][j].equals("_")) {
					if (x[i][j].equals("X")) {
						didP1Win = true;
					} else if (x[i][j].equals("O")) {
						didP2Win = true;
					}
				}
			}
		}

		for (int i = 5; i >= 3; i--) {
			for (int j = 6; j >= 4; j--) {
				if (x[i][j].equals(x[i - 1][j - 1]) && x[i - 1][j - 1].equals(x[i - 2][j - 2])
						&& x[i - 2][j - 2].equals(x[i - 3][j - 3])) {
					if (x[i][j].equals("X")) {
						didP1Win = true;
					} else if (x[i][j].equals("O")) {
						didP2Win = true;
					}
				}
			}
		}
	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (x[i][j].equals(x[i+1][j+1]) && x[i+1][j+1].equals(x[i+2][j+2]) && x[i+2][j+2].equals(x[i+3][j+3])) {
					if (x[i][j].equals("X")) {
						didP1Win = true;
					} else if (x[i][j].equals("O")) { 
						didP2Win = true;
					}
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for (int j = 6; j > 3; j--) {
				if (x[i][j].equals(x[i+1][j-1]) && x[i+1][j-1].equals(x[i+2][j-2]) && x[i+2][j-2].equals(x[i+3][j-3])) {
					if (x[i][j].equals("X")) {
						didP1Win = true;
					} else if (x[i][j].equals("O")) { 
						didP2Win = true;
					}
				}
			}
		}

		if (didP1Win || didP2Win) {
			isWin = true;
		}

		return isWin;
	}
}
