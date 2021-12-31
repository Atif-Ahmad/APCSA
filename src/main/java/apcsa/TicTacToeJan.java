package apcsa;

import java.util.Scanner;

public class TicTacToeJan {

	public static void main(String[] args) {
		boolean didp1win = false;
		boolean didp2win = false;
		boolean isStalemate = false;
		Scanner sc = new Scanner(System.in);

		int i = 0;

		String x1 = " ";
		String x2 = " ";
		String x3 = " ";
		String x4 = " ";
		String x5 = " ";
		String x6 = " ";
		String x7 = " ";
		String x8 = " ";
		String x9 = " ";

		String board = x1 + "|" + x2 + "|" + x3 + " \n" + "-----\n" + x4 + "|" + x5 + "|" + x6 + "\n" + "-----\n" + x7
				+ "|" + x8 + "|" + x9;
		System.out.println(board);

		while (!didp1win && !didp2win && !isStalemate) {
			System.out.println("Player 1 enter a position from 1 - 9");
			int playerpos1 = sc.nextInt();
			if (playerpos1 == 1 && x1.equals(" ")) {
				x1 = "X";
			} else {
				//I thought I could code the error statements
				//but it proved to be too difficult.
				//If you input the same number, it will record 
				//it. The game mechanics will still ask you to
				//input a new number, but I was not able
				//to display it.
				while (!x1.equals(" ") && playerpos1 == 1) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 2 && x2.equals(" ")) {
				x2 = "X";
			} else {
				while (!x2.equals(" ") && playerpos1 == 2) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 3 && x3.equals(" ")) {
				x3 = "X";
			} else {
				while (!x3.equals(" ") && playerpos1 == 3) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 4 && x4.equals(" ")) {
				x4 = "X";
			} else {
				while (!x4.equals(" ") && playerpos1 == 4) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 5 && x5.equals(" ")) {
				x5 = "X";
			} else {
				while (!x5.equals(" ") && playerpos1 == 5) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 6 && x6.equals(" ")) {
				x6 = "X";
			} else {
				while (!x6.equals(" ") && playerpos1 == 6) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 7 && x7.equals(" ")) {
				x7 = "X";
			} else {
				while (!x7.equals(" ") && playerpos1 == 7) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 8 && x8.equals(" ")) {
				x8 = "X";
			} else {
				while (!x8.equals(" ") && playerpos1 == 8) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			if (playerpos1 == 9 && x9.equals(" ")) {
				x9 = "X";
			} else {
				while (!x9.equals(" ") && playerpos1 == 9) {
					System.out.println("Enter another value pls");
					playerpos1 = sc.nextInt();
					sc.nextLine();
				}

			}
			board = x1 + "|" + x2 + "|" + x3 + " \n" + "-----\n" + x4 + "|" + x5 + "|" + x6 + "\n" + "-----\n" + x7
					+ "|" + x8 + "|" + x9;
			System.out.println(board);

			System.out.println("PLAYER 1 HATH PLAYED!!!");

			if (x1.equals(x4) && x4.equals(x7) && x1.equals("X")) {
				didp1win = true;
			} else if (x1.equals(x2) && x2.equals(x3) && x1.equals("X")) {
				didp1win = true;
			} else if (x1.equals(x5) && x5.equals(x9) && x1.equals("X")) {
				didp1win = true;
			} else if (x2.equals(x5) && x5.equals(x8) && x2.equals("X")) {
				didp1win = true;
			} else if (x3.equals(x6) && x6.equals(x9) && x3.equals("X")) {
				didp1win = true;
			} else if (x4.equals(x5) && x5.equals(x6) && x4.equals("X")) {
				didp1win = true;
			} else if (x7.equals(x8) && x8.equals(x9) && x7.equals("X")) {
				didp1win = true;
			} else if (x9.equals(x5) && x5.equals(x1) && x1.equals("X")) {
				didp1win = true;
			} else if (x3.equals(x5) && x5.equals(x7) && x3.equals("X")) {
				didp1win = true;
			}

			if (x1.equals(x5) && x5.equals(x9) && x1.equals("O")) {
				didp2win = true;
			} else if (x1.equals(x2) && x2.equals(x3) && x1.equals("O")) {
				didp2win = true;
			} else if (x1.equals(x5) && x5.equals(x9) && x1.equals("O")) {
				didp2win = true;
			} else if (x2.equals(x5) && x5.equals(x8) && x2.equals("O")) {
				didp2win = true;
			} else if (x3.equals(x6) && x6.equals(x9) && x3.equals("O")) {
				didp2win = true;
			} else if (x4.equals(x5) && x5.equals(x6) && x4.equals("O")) {
				didp2win = true;
			} else if (x7.equals(x8) && x8.equals(x9) && x7.equals("O")) {
				didp2win = true;
			} else if (x3.equals(x5) && x5.equals(x7) && x7.equals("O")) {
				didp2win = true;
			}

			i++;

			if ((!didp2win && !didp1win && !x1.equals(" ") && !x2.equals(" ") && x3.equals(" ") && !x4.equals(" ")
					&& !x5.equals(" ") && x6.equals(" ") && !x7.equals(" ") && !x8.equals(" ") && !x9.equals(" "))
					|| i > 8) {
				isStalemate = true;
			}

			if (!didp1win && !didp2win && !isStalemate) {
				i++;
				System.out.println("Player 2 enter a position from 1 - 9");
				int playerpos2 = sc.nextInt();
				if (playerpos2 == 1 && x1.equals(" ")) {
					x1 = "O";
				} else {
					while (!x1.equals(" ") && playerpos2 == 1) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 2 && x2.equals(" ")) {
					x2 = "O";
				} else {
					while (!x2.equals(" ") && playerpos2 == 2) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 3 && x3.equals(" ")) {
					x3 = "O";
				} else {
					while (!x3.equals(" ") && playerpos2 == 3) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 4 && x4.equals(" ")) {
					x4 = "O";
				} else {
					while (!x4.equals(" ") && playerpos2 == 4) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 5 && x5.equals(" ")) {
					x5 = "O";
				} else {
					while (!x5.equals(" ") && playerpos2 == 5) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 6 && x6.equals(" ")) {
					x6 = "O";
				} else {
					while (!x6.equals(" ") && playerpos2 == 6) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}
				}
				if (playerpos2 == 7 && x7.equals(" ")) {
					x7 = "O";
				} else {
					while (!x7.equals(" ") && playerpos2 == 7) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 8 && x8.equals(" ")) {
					x8 = "O";
				} else {
					while (!x8.equals(" ") && playerpos2 == 8) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}

				}
				if (playerpos2 == 9 && x9.equals(" ")) {
					x9 = "O";
				} else {
					while (!x9.equals(" ") && playerpos2 == 9) {
						System.out.println("Enter another value pls");
						playerpos2 = sc.nextInt();
						sc.nextLine();
					}
					
				}

				board = x1 + "|" + x2 + "|" + x3 + " \n" + "-----\n" + x4 + "|" + x5 + "|" + x6 + "\n" + "-----\n" + x7
						+ "|" + x8 + "|" + x9;
				System.out.println(board);
				System.out.println("Player 2 HATH PLAYED");
			}

			if (x1.equals(x4) && x4.equals(x7) && x1.equals("X")) {
				didp1win = true;
			} else if (x1.equals(x2) && x2.equals(x3) && x1.equals("X")) {
				didp1win = true;
			} else if (x1.equals(x4) && x4.equals(x9) && x1.equals("X")) {
				didp1win = true;
			} else if (x2.equals(x5) && x5.equals(x8) && x2.equals("X")) {
				didp1win = true;
			} else if (x3.equals(x6) && x6.equals(x9) && x3.equals("X")) {
				didp1win = true;
			} else if (x4.equals(x5) && x5.equals(x6) && x4.equals("X")) {
				didp1win = true;
			} else if (x7.equals(x8) && x8.equals(x9) && x7.equals("X")) {
				didp1win = true;
			} else if (x7.equals(x5) && x5.equals(x3) && x7.equals("X")) {
				didp1win = true;
			}

			if (x1.equals(x5) && x5.equals(x9) && x1.equals("O")) {
				didp2win = true;
			} else if (x1.equals(x2) && x2.equals(x3) && x1.equals("O")) {
				didp2win = true;
			} else if (x1.equals(x4) && x4.equals(x9) && x1.equals("O")) {
				didp2win = true;
			} else if (x2.equals(x5) && x5.equals(x8) && x2.equals("O")) {
				didp2win = true;
			} else if (x3.equals(x6) && x6.equals(x9) && x3.equals("O")) {
				didp2win = true;
			} else if (x4.equals(x5) && x5.equals(x6) && x4.equals("O")) {
				didp2win = true;
			} else if (x7.equals(x8) && x8.equals(x9) && x7.equals("O")) {
				didp2win = true;
			} else if (x7.equals(x5) && x5.equals(x3) && x7.equals("O")) {
				didp2win = true;
			}

			if ((!didp2win && !didp1win && !x1.equals(" ") && !x2.equals(" ") && x3.equals(" ") && !x4.equals(" ")
					&& !x5.equals(" ") && x6.equals(" ") && !x7.equals(" ") && !x8.equals(" ") && !x9.equals(" "))
					|| i > 8) {
				isStalemate = true;
			}

		}

		if (didp1win) {
			System.out.println("Congrats Player 1");
		} else if (didp2win) {
			System.out.println("Congrats Player 2");
		} else {
			System.out.println("Tie.");
		}
	}

}