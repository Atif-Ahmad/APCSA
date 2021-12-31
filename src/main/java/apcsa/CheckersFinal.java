package apcsa;

import java.util.Scanner;

import Objects.Pieces;

public class CheckersFinal {
	static String[][] board = { { "0", "1", "2", "3", "4", "5", "6", "7", "8" },
			{ "1", "_", "_", "_", "_", "_", "_", "_", "_" }, { "2", "_", "_", "_", "_", "_", "_", "_", "_" },
			{ "3", "_", "_", "_", "_", "_", "_", "_", "_" }, { "4", "_", "_", "_", "_", "_", "_", "_", "_" },
			{ "5", "_", "_", "_", "_", "_", "_", "_", "_" }, { "6", "_", "_", "_", "_", "_", "_", "_", "_" },
			{ "7", "_", "_", "_", "_", "_", "_", "_", "_" }, { "8", "_", "_", "_", "_", "_", "_", "_", "_" } };

	static String P2PIECE = "o";
	static String P2KING = "O";

	static String P1PIECE = "x";
	static String P1KING = "X";

	static Pieces o1 = new Pieces(3, 8, false, P2PIECE);
	static Pieces o2 = new Pieces(3, 6, false, P2PIECE);
	static Pieces o3 = new Pieces(3, 4, false, P2PIECE);
	static Pieces o4 = new Pieces(3, 2, false, P2PIECE);
	static Pieces o5 = new Pieces(2, 1, false, P2PIECE);
	static Pieces o6 = new Pieces(2, 3, false, P2PIECE);
	static Pieces o7 = new Pieces(2, 5, false, P2PIECE);
	static Pieces o8 = new Pieces(2, 7, false, P2PIECE);
	static Pieces o9 = new Pieces(1, 8, false, P2PIECE);
	static Pieces o10 = new Pieces(1, 6, false, P2PIECE);
	static Pieces o11 = new Pieces(1, 4, false, P2PIECE);
	static Pieces o12 = new Pieces(1, 2, false, P2PIECE);

	static Pieces[] p2 = { o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12 };

	static Pieces x1 = new Pieces(6, 1, false, P1PIECE);
	static Pieces x2 = new Pieces(6, 3, false, P1PIECE);
	static Pieces x3 = new Pieces(6, 5, false, P1PIECE);
	static Pieces x4 = new Pieces(6, 7, false, P1PIECE);
	static Pieces x5 = new Pieces(7, 2, false, P1PIECE);
	static Pieces x6 = new Pieces(7, 4, false, P1PIECE);
	static Pieces x7 = new Pieces(7, 6, false, P1PIECE);
	static Pieces x8 = new Pieces(7, 8, false, P1PIECE);
	static Pieces x9 = new Pieces(8, 1, false, P1PIECE);
	static Pieces x10 = new Pieces(8, 3, false, P1PIECE);
	static Pieces x11 = new Pieces(8, 5, false, P1PIECE);
	static Pieces x12 = new Pieces(8, 7, false, P1PIECE);

	static Pieces[] p1 = { x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12 };

	static boolean didP1Win = false;
	static boolean didP2Win = false;

	public static void main(String[] args) {
		print(board);
		boolean player1Played = false;
		boolean player2Played = false;
		
		System.out.println("Player 1 is x, player 2 is o. Lowercase represents regular pieces, uppercase represents King.");
		
		System.out.println("To enter a coordinate, enter the vertical coordinate then the horizontal one. \n"
				+ "For example the player 1 top left piece is at coordinate (6,1). The bottom right player 2 piece is at (3,8)");
		
		while (!isWin()) {
			if (!player1Played) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Player 1, Enter coordinates of piece you want to move. To enter a coordinate, simply put x1 y1");
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();

				System.out.println("Enter destination coordinates. To enter a multikill, enter: x2 y2, x3 y3, etc");
				sc.nextLine();
				String coor = sc.nextLine();
				int[][] endpos = split(coor);
				if (endpos.length > 1) {

					player1Played = playMultiStep(x1, y1, endpos, 1);
				} else {

					int x2 = endpos[0][0];
					int y2 = endpos[0][1];

					player1Played = placePiece(x1, y1, x2, y2, 1);
				}

				if (player1Played) {
					setKing(1);
					System.out.println();
					print(board);
					System.out.println("Player 1 hath played.");
				} else {
					System.out.println("Your move was invalid. Play again.");
				}
			} else {
				if (!isWin() && player1Played && !player2Played) {
					System.out.println("Player 2, Enter coordinates of piece you want to move. To enter a coordinate simply input x1 y1");
					Scanner sc = new Scanner(System.in);
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					System.out.println("Enter destination coordinates. To enter a multikill, enter: x2 y2, x3 y3, etc");
					sc.nextLine();
					String coor = sc.nextLine();
					int[][] endpos = split(coor);
					endpos = split(coor);
					if (endpos.length > 1) {

						player2Played = playMultiStep(x1, y1, endpos, 2);
					} else {
						int x2 = endpos[0][0];
						int y2 = endpos[0][1];

						player2Played = placePiece(x1, y1, x2, y2, 2);
					}
					if (player2Played) {
						System.out.println();
						setKing(2);
						print(board);
						System.out.println("Player 2 hath played");
					} else {
						System.out.println("Please enter another move since your move was invalid");
					}
				}
			}
			if (player1Played && player2Played) {
				player1Played = false;
				player2Played = false;
			}
		}

		if (didP1Win) {
			System.out.println("Player 1 win");
		} else if (didP2Win) {
			System.out.println("Player 2 win");
		}
	}

	private static boolean playMultiStep(int x, int y, int[][] endpos, int player) {
		for (int i = 0; i < endpos.length; i++) {
			int x2 = endpos[i][0];
			int y2 = endpos[i][1];

			boolean b = placePiece(x, y, x2, y2, player);
			print(board);

			if (!b) {
				// fnid the piece at x2,y2
				// and set its coordinate to x,y
				if (player == 1 && i > 0) {
					for (Pieces p : p1) {
						if (p.getX() == x2 && p.getY() == y2) {
							p.setX(endpos[i - 1][0]);
							p.setY(endpos[i - 1][1]);
							return false;
						}

					}
//					for (Pieces p : p1) {
//						board[p.getX()][p.getY()] = p.getPiece();
//					}
				} else {
					for (Pieces p : p2) {
						if (p.getX() == x2 && p.getY() == y2) {
							p.setX(endpos[i - 1][0]);
							p.setY(endpos[i - 1][1]);
							return false;
						}
					}
					for (Pieces p : p2) {
						board[p.getX()][p.getY()] = p.getPiece();
					}
				}
			}
			x = x2;
			y = y2;
		}
		return true;

	}

	private static int[][] split(String coor) {
		// TODO Auto-generated method stub

		String[] res = coor.trim().split(",");

		int[][] output = new int[res.length][2];

		int i = 0;
		for (String r : res) {
			String[] o = r.trim().split(" ");
			int x = Integer.parseInt(o[0]);
			int y = Integer.parseInt(o[1]);

			output[i][0] = x;
			output[i][1] = y;
			i++;

		}
		return output;

	}

	public static boolean placePiece(int x1, int y1, int x2, int y2, int player) {
		boolean validMove = true;
		// validate edge constraints of x2 and y2
		if ((x1 < 1 || x1 > 8) || (y1 < 1 || y1 > 8) || (x2 < 1 || x2 > 8) || (y2 < 1 || y2 > 8)) {
			System.out.println("Error");
			return false;
		}

		// check if x1,y1 is king

		if (player == 1) {
			if (isKingAt(x1, y1, 1)) {
				moveKing(x1, y1, x2, y2, 1);
			} else {
				if (board[x1][y1].equals(P1PIECE) && board[x2][y2].equals("_") && (x2 == x1 - 1)
						&& (y2 == y1 + 1 || y2 == y1 - 1)) {
					for (Pieces p : p1) {
						if (p.getX() == x1 && p.getY() == y1) {
							p.setX(x2);
							p.setY(y2);
						}
					}
				} else if (board[x1][y1].equals(P1PIECE) && board[x2][y2].equals("_") && (x2 == x1 - 2)
						&& (y2 == y1 + 2 || y2 == y1 - 2)
						&& ((x1 > 0 && y1 > 0 && (board[x1 - 1][y1 - 1].equalsIgnoreCase(P2PIECE))
								|| (x1 > 0 && y1 < 8 && board[x1 - 1][y1 + 1].equalsIgnoreCase(P2PIECE))))) {
					for (Pieces p : p1) {
						if (p.getX() == x1 && p.getY() == y1) {
							p.setX(x2);
							p.setY(y2);
						}
					}
					for (Pieces p : p2) {
						if (p.getX() == x1 - 1 && ((x1 + x2) / 2 == p.getX() && (y1 + y2) / 2 == p.getY())) {
							p2 = remove(p2, p);
						}
					}
				} else {
					System.out.println("Invalid Move");
					validMove = false;
				}
			}
		} else {
			if (isKingAt(x1, y1, 2)) {
				moveKing(x1, y1, x2, y2, 2);
			} else {
				if (board[x1][y1].equals(P2PIECE) && board[x2][y2].equals("_") && x2 == x1 + 1
						&& (y2 == y1 + 1 || y2 == y1 - 1)) {
					for (Pieces p : p2) {
						if (p.getX() == x1 && p.getY() == y1) {
							p.setX(x2);
							p.setY(y2);
						}
					}
				} else if (board[x1][y1].equals(P2PIECE) && board[x2][y2].equals("_") && x2 == x1 + 2
						&& (y2 == y1 + 2 || y2 == y1 - 2)
						&& ((x1 < 8 && y1 < 8 && (board[x1 + 1][y1 + 1].equalsIgnoreCase(P1PIECE))
								|| (x1 < 8 && y1 > 0 && board[x1 + 1][y1 - 1].equalsIgnoreCase(P1PIECE))))) {
					for (Pieces p : p2) {
						if (p.getX() == x1 && p.getY() == y1) {
							p.setX(x2);
							p.setY(y2);
						}
					}
					for (Pieces p : p1) {
						if (p.getX() == x1 + 1 && (x1 + x2) / 2 == p.getX() && (y1 + y2) / 2 == p.getY()) {
							p1 = remove(p1, p);
						}
					}
				} else {
					System.out.println("Invalid move");
					validMove = false;
				}
			}
		}
		return validMove;
		// for kill placement

	}

	private static boolean moveKing(int x1, int y1, int x2, int y2, int player) {
		boolean validMove = true;
		// validate edge constraints of x2 and y2
		if ((x1 < 1 || x1 > 8) || (y1 < 1 || y1 > 8) || (x2 < 1 || x2 > 8) || (y2 < 1 || y2 > 8)) {
			System.out.println("Error");
			return false;
		}

		// check if x1,y1 is king

		if (player == 1) {
			if (board[x1][y1].equals(P1KING) && board[x2][y2].equals("_") && (x2 == x1 - 1 || x2 == x1 + 1)
					&& (y2 == y1 + 1 || y2 == y1 - 1)) {

				for (Pieces p : p1) {
					if (p.getX() == x1 && p.getY() == y1) {
						p.setX(x2);
						p.setY(y2);
					}
				}
			} else if (board[x1][y1].equals(P1KING) && board[x2][y2].equals("_") && (x2 == x1 - 2 || x2 == x1 + 2)
					&& (y2 == y1 + 2 || y2 == y1 - 2)
					&& ((x1 > 0 && (board[x1 - 1][y1 - 1].equalsIgnoreCase(P2PIECE)
							|| board[x1 - 1][y1 + 1].equalsIgnoreCase(P2PIECE)))
							|| (x1 < 8 && (board[x1 + 1][y1 - 1].equalsIgnoreCase(P2PIECE)
									|| board[x1 + 1][y1 + 1].equalsIgnoreCase(P2PIECE))))) {
				for (Pieces p : p1) {
					if (p.getX() == x1 && p.getY() == y1) {
						p.setX(x2);
						p.setY(y2);
					}
				}
				for (Pieces p : p2) {
					if ((p.getX() == x1 - 1 || p.getX() == x1 + 1)
							&& ((x1 + x2) / 2 == p.getX() && (y1 + y2) / 2 == p.getY())) {
						p2 = remove(p2, p);
					}
				}
			} else {
				System.out.println("Invalid Move");
				validMove = false;
			}

		} else {

			if (board[x1][y1].equals(P2KING) && board[x2][y2].equals("_") && (x2 == x1 + 1 || x2 == x1 - 1)
					&& (y2 == y1 + 1 || y2 == y1 - 1)) {
				for (Pieces p : p2) {
					if (p.getX() == x1 && p.getY() == y1) {
						p.setX(x2);
						p.setY(y2);
					}
				}
			} else if (board[x1][y1].equals(P2KING) && board[x2][y2].equals("_") && (x2 == x1 + 2 || x2 == x1 - 2)
					&& (y2 == y1 + 2 || y2 == y1 - 2)
					&& ((x1 < 8 && (board[x1 + 1][y1 + 1].equalsIgnoreCase("X"))
							|| x1 < 8 && board[x1 + 1][y1 - 1].equalsIgnoreCase("X")
							|| ((x1 > 0 && y1 < 8 && (board[x1 - 1][y1 + 1].equalsIgnoreCase("X")))
									|| (x1 > 0 && y1 > 0 && board[x1 - 1][y1 - 1].equalsIgnoreCase("X")))))) {
				for (Pieces p : p2) {
					if (p.getX() == x1 && p.getY() == y1) {
						p.setX(x2);
						p.setY(y2);
					}
				}
				for (Pieces p : p1) {
					if ((p.getX() == x1 + 1 || p.getX() == x1 - 1) && (x1 + x2) / 2 == p.getX()
							&& (y1 + y2) / 2 == p.getY()) {
						p1 = remove(p1, p);
					}
				}
			} else {
				System.out.println("Invalid move");
				validMove = false;
			}

		}
		return validMove;

	}

	public static void print(String[][] arr) {
		clearBoard();

		for (int i = 0; i < 9; i++) {
			board[i][0] = i + "";
		}
		for (int i = 0; i < 9; i++) {
			board[0][i] = i + "";
		}
		for (Pieces p : p1) {
			board[p.getX()][p.getY()] = p.getPiece();
		}
		for (Pieces p : p2) {
			board[p.getX()][p.getY()] = p.getPiece();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void clearBoard() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = "_";
			}
		}

	}

//	public static boolean isTie(int player) { // I tried coding the tie method
//		int xSingle = 1;
//		int xDouble = 2;
//
//		int countre = 0;
//
//		if (player == 1) {
//
//			for (Pieces p : p1) {
//				if (p.kingStatus()) {
//
//				} else {
//					if (p.getY() == 1) {
//
//						if (p.getX() == 1) {
//							countre++;
//						} else if (p.getX() == 2) {
//							if (!board[1][2].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() + 1].equals("_")
//									&& (!board[p.getX() - xDouble][p.getY() + 2].equals("_")
//											&& ( !board[p.getX() - xSingle][p.getY() + 1].equals(P2PIECE) ||  !board[p.getX() - xSingle][p.getY() + 1].equals(P2KING)))) {
//								countre++;
//							}
//						}
//					} else if (p.getY() == 8) {
//						if (p.getX() == 1) {
//							return false;
//						} else if (p.getX() == 2) {
//							if (!board[1][7].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() - 1].equals("_")
//									&& !board[p.getX() - xDouble][p.getY() - 2].equals("_")) {
//								countre++;
//							}
//						}
//					} else if (p.getY() == 2) {
//						if (p.getX() == 1) {
//							countre++;
//						} else if (p.getX() == 2) {
//							if (!board[1][1].equals("_") || !board[1][3].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() - 1].equals("_")
//									|| ((!board[p.getX() - xSingle][p.getY() + 1].equals(P2PIECE) || !board[p.getX() - xSingle][p.getY() + 1].equals(P2KING))
//											&& !board[p.getX() - xDouble][p.getY() + 2].equals("_"))) {
//								countre++;
//							}
//
//						}
//					} else if (p.getY() == 7) {
//						if (p.getX() == 1) {
//							countre++;
//						} else if (p.getX() == 2) {
//							if (!board[1][6].equals("_") || !board[1][8].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() + 1].equals("_")
//									|| ((!board[p.getX() - xSingle][p.getY() - 1].equals(P2PIECE) || !board[p.getX() - xSingle][p.getY() - 1].equals(P2KING))
//											&& !board[p.getX() - xDouble][p.getY() - 2].equals("_"))) {
//								countre++;
//							}
//						}
//					} else {
//						if (p.getX() == 1) {
//							countre++;
//						} else if (p.getX() == 2) {
//							if (!board[p.getX() - xSingle][p.getY() - 1].equals("_")
//									|| !board[p.getX() - 1][p.getY() + 1].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - xSingle][p.getY() - 1].equals("_")
//									|| (!board[p.getX() - xDouble][p.getY() - 2].equals("_")
//											&& !board[p.getX() - 1][p.getY() - 1].equals("_"))
//									|| board[p.getX() - xSingle][p.getY() + 1].equals("_")
//									|| (!board[p.getX() - xDouble][p.getY() + 2].equals("_")
//											&& !board[p.getX() - xSingle][p.getY() - 1].equals(P2PIECE))) {
//								countre++;
//							}
//						}
//					}
//				}
//			}
//		} else { // for player 2
//					// ***********************************************************************
//			xDouble = -2;
//			xSingle = -1;
//			for (Pieces p : p2) {
//				if (p.kingStatus()) {
//
//				} else {
//					if (p.getY() == 1) {
//
//						if (p.getX() == 8) {
//							countre++;
//						} else if (p.getX() == 7) {
//							if (!board[8][2].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() + 1].equals("_")
//									&& (!board[p.getX() - xDouble][p.getY() + 2].equals("_")
//											&& (!board[p.getX() - xSingle][p.getY() + 1].equals(P1PIECE) || !board[p.getX() - xSingle][p.getY() + 1].equals(P1PIECE) ))) {
//								countre++;
//							}
//						}
//					} else if (p.getY() == 8) {
//						if (p.getX() == 8) {
//							countre++;
//						} else if (p.getX() == 7) {
//							if (!board[8][7].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() + 1][p.getY() - 1].equals("_")
//									&& !board[p.getX() - xDouble][p.getY() - 2].equals("_")) {
//								countre++;
//							}
//						}
//					} else if (p.getY() == 2) {
//						if (p.getX() == 8) {
//							countre++;
//						} else if (p.getX() == 7) {
//							if (!board[8][1].equals("_") || !board[8][3].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() - 1].equals("_")
//									|| ((!board[p.getX() - xSingle][p.getY() + 1].equalsIgnoreCase(P1PIECE) || !board[p.getX() - xSingle][p.getY() + 1].equalsIgnoreCase(P1KING))
//											&& !board[p.getX() - xDouble][p.getY() + 2].equals("_"))) {
//								countre++;
//							}
//
//						}
//					} else if (p.getY() == 7) {
//						if (p.getX() == 8) {
//							countre++;
//						} else if (p.getX() == 7) {
//							if (!board[8][6].equals("_") || !board[8][8].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - 1][p.getY() + 1].equals("_")
//									&& ((!board[p.getX() - xSingle][p.getY() - 1].equals(P1PIECE) || !board[p.getX() - xSingle][p.getY() - 1].equals(P1KING))
//											&& !board[p.getX() - xDouble][p.getY() - 2].equals("_"))) {
//								countre++;
//							}
//						}
//					} else {
//						if (p.getX() == 1) {
//							countre++;
//						} else if (p.getX() == 2) {
//							if (!board[p.getX() - xSingle][p.getY() - 1].equals("_")
//									|| !board[p.getX() - 1][p.getY() + 1].equals("_")) {
//								countre++;
//							}
//						} else {
//							if (!board[p.getX() - xSingle][p.getY() - 1].equals("_")
//									|| (!board[p.getX() - xDouble][p.getY() - 2].equals("_")
//											&& !board[p.getX() - 1][p.getY() - 1].equals("_"))
//									|| board[p.getX() - xSingle][p.getY() + 1].equals("_")
//									|| (!board[p.getX() - xDouble][p.getY() + 2].equals("_")
//											&& (!board[p.getX() - xSingle][p.getY() - 1].equals(P1PIECE) || !board[p.getX() - xSingle][p.getY() - 1].equals(P1KING)))) {
//								countre++;
//							}
//						}
//					}
//				}
//			}
//		}
//		if (player == 1 && countre == p1.length) {
//			return true;
//		} else if (player == 2 && countre == p2.length) {
//			return true;
//		} else {
//			return false;
//		}
//
//	}

	public static Pieces[] remove(Pieces[] arr, Pieces p) {

		Pieces[] arr1 = new Pieces[arr.length - 1];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!(Pieces.isEqual(arr[i], p))) {
				arr1[j] = arr[i];
				j++;
			}
		}
		return arr1;
	}

	public static boolean isWin() {
		if (p2.length == 0) {
			didP1Win = true;
		} else if (p1.length == 0) {
			didP2Win = true;
		}

		if (didP1Win || didP2Win) {
			return true;
		} else {
			return false;
		}
	}

	public static void setKing(int player) {
		if (player == 1) {
			for (Pieces p : p1) {
				if (p.getX() == 1) {
					p.makeKing(true);
					p.setPiece("X");
				}
			}
		} else {
			for (Pieces p : p2) {
				if (p.getX() == 8) {
					p.makeKing(true);
					p.setPiece("O");
				}
			}
		}
	}

	public static boolean isKingAt(int x1, int y1, int player) {
		if (player == 1) {
			for (Pieces p : p1) {
				if (p.kingStatus() && p.getX() == x1 && p.getY() == y1) {
					return true;
				}
			}
		} else {
			for (Pieces p : p2) {
				if (p.kingStatus() && p.getX() == x1 && p.getY() == y1) {
					return true;
				}
			}
		}
		return false;
	}

	// automated test cases, not part of actual code functionality
	public static void automated1() {
		print(board);
		placePiece(6, 1, 5, 2, 1);
		print(board);
		placePiece(3, 4, 4, 3, 2);
		print(board);
		placePiece(5, 2, 3, 4, 1);
		print(board);
		placePiece(2, 3, 4, 5, 2);
		print(board);
		placePiece(6, 7, 5, 6, 1);
		print(board);
		placePiece(4, 5, 6, 7, 2);
		print(board);
		placePiece(7, 8, 5, 6, 1);
		print(board);
		placePiece(3, 8, 4, 7, 2);
		print(board);
		placePiece(5, 6, 3, 8, 1);
		print(board);
		placePiece(3, 6, 4, 5, 2);
		print(board);
		placePiece(6, 5, 5, 6, 1);
		print(board);
		placePiece(4, 5, 6, 7, 2);
		print(board);
		placePiece(7, 6, 5, 8, 1);
		print(board);
		placePiece(2, 5, 3, 4, 2);
		print(board);
		placePiece(6, 3, 5, 4, 1);
		print(board);
		placePiece(3, 2, 4, 3, 2);
		print(board);
		placePiece(5, 4, 3, 2, 1);
		print(board);
		placePiece(2, 1, 4, 3, 2);
		print(board);
		placePiece(7, 2, 6, 3, 1);
		print(board);
		placePiece(4, 3, 5, 4, 2);
		print(board);
		placePiece(6, 3, 4, 5, 1);
		print(board);
		placePiece(3, 4, 5, 6, 2);
		print(board);
		placePiece(7, 4, 6, 5, 1);
		print(board);
		placePiece(5, 6, 7, 4, 2);
		print(board);
		placePiece(8, 3, 6, 5, 1);
		print(board);
		placePiece(1, 4, 2, 5, 2);
		print(board);
		placePiece(8, 1, 7, 2, 1);
		print(board);
		placePiece(2, 5, 3, 6, 2);
		print(board);
		placePiece(7, 2, 6, 3, 1);
		print(board);
		placePiece(3, 6, 4, 7, 2);
		print(board);
		placePiece(5, 8, 3, 6, 1);
		print(board);
		placePiece(1, 6, 2, 5, 2);
		print(board);
		placePiece(3, 8, 1, 6, 1);
		setKing(1);
		print(board);
		placePiece(1, 2, 2, 3, 2);
		print(board);

	}

	public static void kingTest() {
		print(board);
		placePiece(6, 1, 5, 2, 1);
		print(board);
		placePiece(3, 4, 4, 3, 2);
		print(board);
		placePiece(5, 2, 3, 4, 1);
		print(board);
		placePiece(2, 3, 4, 5, 2);
		print(board);
		placePiece(6, 7, 5, 6, 1);
		print(board);
		placePiece(4, 5, 6, 7, 2);
		print(board);
		placePiece(7, 8, 5, 6, 1);
		print(board);
		placePiece(3, 8, 4, 7, 2);
		print(board);
		placePiece(6, 3, 5, 4, 1);
		print(board);
		placePiece(2, 5, 3, 4, 2);
		print(board);
		placePiece(7, 2, 6, 1, 1);
		print(board);
		placePiece(1, 6, 2, 5, 2);
		print(board);
		placePiece(5, 6, 3, 8, 1);
		print(board);
		placePiece(3, 2, 4, 1, 2);
		print(board);
		placePiece(3, 8, 1, 6, 1);
		setKing(1);
		print(board);
		placePiece(3, 4, 4, 5, 2);
		print(board);
		placePiece(1, 6, 3, 4, 1);
		print(board);
		placePiece(4, 1, 5, 2, 2);
		print(board);
	}

	public static void TieTest() {
		automated1();
		placePiece(1, 6, 3, 4, 1);
		print(board);
		placePiece(2, 3, 4, 5, 2);
		print(board);
		placePiece(3, 6, 2, 7, 1);
		print(board);
		placePiece(4, 5, 5, 6, 2);
		print(board);
		placePiece(6, 3, 5, 4, 1);
		print(board);
		placePiece(5, 6, 7, 4, 2);
		print(board);
		placePiece(5, 4, 4, 5, 1);
		print(board);
		placePiece(7, 4, 8, 3, 2);
		print(board);
		placePiece(4, 5, 3, 6, 1);
		print(board);
		placePiece(8, 3, 7, 4, 2);
		setKing(2);
		print(board);
		placePiece(8, 7, 7, 6, 1);
		print(board);
		placePiece(8, 3, 7, 4, 2);
		print(board);
//		placePiece(8,5, 6,3, 1);
//		print(board);

	}

	public static void testTie2() {
		automated1();
		setKing(1);
		placePiece(6, 3, 5, 2, 1);
		print(board);
		placePiece(2, 5, 5, 4, 2);
		print(board);
		placePiece(5, 2, 4, 1, 1);
		print(board);
		placePiece(3, 4, 4, 5, 2);
		print(board);
		placePiece(4, 1, 3, 2, 1);
		print(board);
		placePiece(4, 5, 5, 6, 2);
		print(board);
		placePiece(3, 2, 1, 4, 1);
		setKing(1);
		print(board);
		placePiece(5, 6, 6, 7, 2);
		print(board);
		placePiece(8, 7, 7, 6, 1);
		print(board);
		placePiece(5, 6, 6, 7, 2);
		print(board);
		placePiece(8, 7, 7, 6, 1);
		print(board);
		placePiece(6, 7, 7, 8, 2);
		print(board);
		placePiece(6, 5, 5, 4, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		setKing(2);
		print(board);
		placePiece(5, 4, 4, 3, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(4, 3, 3, 2, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(3, 2, 2, 3, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(2, 3, 1, 2, 1);
		setKing(1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(1, 4, 2, 5, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(1, 2, 2, 3, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(2, 5, 3, 4, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(3, 4, 4, 5, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(4, 5, 5, 4, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(5, 4, 6, 5, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(1, 6, 2, 7, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(2, 3, 3, 4, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(3, 4, 4, 5, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(4, 5, 5, 6, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
		placePiece(5, 6, 6, 7, 1);
		print(board);
		placePiece(8, 7, 7, 8, 2);
		print(board);
		placePiece(8, 5, 7, 4, 1);
		print(board);
		placePiece(7, 8, 8, 7, 2);
		print(board);
//		placePiece(6,7, 7,8, 1);
//		print(board);
//		placePiece() 
	}

	public static void multikill() {
		placePiece(6, 1, 5, 2, 1);
		print(board);
		placePiece(3, 4, 4, 3, 2);
		print(board);
		placePiece(6, 7, 5, 8, 1);
		print(board);
		placePiece(3, 6, 4, 5, 2);
		print(board);
		placePiece(7, 8, 6, 7, 1);
		print(board);
		placePiece(2, 7, 3, 6, 2);
		print(board);
		placePiece(5, 8, 4, 7, 1);
		print(board);
		placePiece(1, 6, 2, 7, 2);
		print(board);
//		placePiece(5,2, 3,4, 1);
//		placePiece(3,4, 1,6, 1);
//		print(board);
//		placePiece(3,2, 4,3, 2);
//		print(board);
//		placePiece(6,3, 5,2, 1);
//		print(board);
//		placePiece(2,3, 3,4, 2);
//		print(board);
////		placePiece(7,4, 6,3, 1);
////		print(board);
	}

	public static void tieTest2() {
		placePiece(6, 3, 5, 4, 1);
		setKing(1);
		print(board);
		placePiece(3, 2, 4, 3, 2);
		setKing(2);
		print(board);
		placePiece(6, 1, 5, 2, 1);
		setKing(1);
		print(board);
		placePiece(3, 6, 4, 7, 2);
		setKing(2);
		print(board);
		placePiece(7, 2, 6, 3, 1);
		setKing(1);
		print(board);
		placePiece(2, 5, 3, 6, 2);
		setKing(2);
		print(board);
		placePiece(8, 1, 7, 2, 1);
		setKing(1);
		print(board);
		placePiece(1, 4, 2, 5, 2);
		setKing(2);
		print(board);
		placePiece(5, 4, 3, 2, 1);
		setKing(1);
		print(board);
		placePiece(3, 2, 1, 4, 1);
		setKing(1);
		print(board);
		placePiece(3, 6, 4, 5, 2);
		setKing(2);
		print(board);
		placePiece(1, 4, 3, 6, 1);
		setKing(1);
		print(board);
		placePiece(3, 6, 5, 8, 1);
		setKing(1);
		print(board);
		placePiece(2, 1, 3, 2, 2);
		setKing(2);
		print(board);
		placePiece(6, 3, 5, 4, 1);
		setKing(2);
		print(board);
		placePiece(1, 2, 2, 3, 2);
		setKing(2);
		print(board);
		placePiece(6, 7, 5, 6, 1);
		setKing(1);
		print(board);
		placePiece(3, 2, 4, 1, 2);
		setKing(2);
		print(board);
		placePiece(7, 6, 6, 7, 1);
		setKing(1);
		print(board);
		placePiece(3, 4, 4, 3, 2);
		setKing(2);
		print(board);
		placePiece(5, 6, 3, 4, 1);
		setKing(1);
		print(board);
		placePiece(3, 4, 1, 2, 1);
		setKing(1);
		print(board);
		placePiece(3, 8, 4, 7, 2);
		setKing(2);
		print(board);
		placePiece(8, 5, 7, 6, 1);
		setKing(1);
		print(board);
		placePiece(4, 1, 6, 3, 2);
		setKing(2);
		print(board);
		placePiece(6, 3, 8, 5, 2);
		setKing(2);
		print(board);
		placePiece(5, 4, 4, 5, 1);
		setKing(1);
		print(board);
		placePiece(4, 3, 5, 4, 2);
		setKing(2);
		print(board);
		placePiece(5, 8, 3, 6, 1);
		setKing(1);
		print(board);
		placePiece(5, 4, 6, 3, 2);
		setKing(2);
		print(board);
		placePiece(6, 7, 5, 8, 1);
		setKing(1);
		print(board);
		placePiece(6, 3, 8, 1, 2);
		setKing(2);
		print(board);
		placePiece(8, 3, 7, 2, 1);
		setKing(1);
		print(board);
		placePiece(8, 5, 6, 7, 2);
		setKing(2);
		print(board);
		placePiece(1, 2, 2, 3, 1);
		print(board);
		placePiece(6, 7, 5, 6, 2);
		print(board);
		placePiece(6, 5, 4, 7, 1);
		print(board);
		placePiece(8, 1, 6, 3, 2);
		print(board);
		placePiece(3, 6, 2, 5, 1);
		print(board);
		placePiece(6, 3, 7, 2, 2);
		print(board);
		placePiece(2, 3, 3, 4, 1);
		print(board);
		placePiece(7, 2, 6, 3, 2);
		print(board);
		placePiece(4, 7, 3, 6, 1);
		print(board);
		placePiece(6, 3, 7, 4, 2);
		print(board);
		placePiece(5, 8, 7, 4, 1);
		print(board);
		placePiece(7, 4, 6, 5, 2);
		print(board);
		placePiece(4, 7, 3, 8, 1);
		print(board);
		placePiece(6, 5, 7, 6, 2);
		print(board);
		placePiece(5, 8, 4, 7, 1);
		print(board);
		placePiece(7, 6, 6, 7, 2);
		print(board);
		placePiece(4, 7, 3, 8, 1);
		print(board);
		placePiece(6, 7, 7, 6, 2);
		print(board);
//		placePiece(8,7, 6,5, 1);
//		print(board);
	}
}