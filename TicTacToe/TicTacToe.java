import java.io.*;
import java.util.*;


public class TicTacToe {
	
	static boolean done = false; // identify if the game of tic-tac-toe is finished
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in); // setting up the scanner
		
		//Introduction to the tic-tac-toe game
		System.out.println("Welcome! In this tic-toe-game you will play against a computer!"); // Basic Introduction
		System.out.println("What is your name?"); // collecting user's name
		String user_name = scan.next(); // storing the user's name as a String: user_name
		System.out.println(user_name + ", you will be (O). " + "Computer will be (X)."); // printing who will be what (computer will be X, user will be O)
		
		
		String [][] board = {{".",".","."},{".",".","."},{".",".","."}}; // initializing the array board of tic-tac-toe, with . as blank spaces

		
		
		//FIRST MOVE OF THE COMPUTER (same for all of the games)
		System.out.println("Computer will play first!");
		board[1][1] = "X";
		printBoard(board);
		
		
		
		while (done != true) { // looping through until a winner has been found or if it is a tie
			
			//USER'S MOVE
			int user_row = -1;
			int user_col = -1;
			boolean user_valid = false; // pre-setting the user input to invalid
			while (user_valid == false) { // loops until user enters a valid input for row and column
				try { // exception
					System.out.println(user_name + ", choose a row to place your move (O) in (it must be between 1-3):");
					user_row = scan.nextInt(); user_row--;
					System.out.println(user_name + ", choose a column to place your move (O) in (it must be between 1-3):");
					user_col = scan.nextInt(); user_col--;
					
					if ((user_row < 0) || (user_row > 2) || (user_col < 0) || (user_col > 2)) // exception
						throw new Exception(); // throws an exception if the input is out of bounds
					
					boolean open_spot_user = openSpotOnBoard(board,user_row,user_col);
					if (open_spot_user == false) 
						throw new Exception(); // throws an exception if the space at input is already occupied
					
					user_valid = true;
				}
				catch (Exception e) { // exception, print statement
					System.out.println("ERROR! TRY AGAIN, your input did not contain a valid input OR the postion of your move s already occupied.");
				}
			}
			fillTheBoard(board,user_row,user_col,"O"); // filling in the board for the user
			printBoard(board);
			
			// VALIDATING IF ANYONE WON (COMPUTER, USER, OR TIE) and breaking out of the program as soon as an end result is found
			boolean tie = isTie(board);
			String winner = check(board);
			if (tie || winner.equals("USER")||winner.equals("COMPUTER")) {
				done = true; // setting the "main" controlling variable: done, to false (indicating that the game is over)
				if (winner.equals("USER")) {
					System.out.println(user_name + ", you WON!!!");
					break;
				}
				if (winner.equals("COMPUTER")) {
					System.out.println("COMPUTER WON!!!");
					break;
				}
				if (tie) {
					System.out.println("THERE IS A TIE");
					break;
				}
			}
				
			
			//COMPUTER'S MOVE
			int computer_row = (int)(Math.random()*3);
			int computer_col = (int)(Math.random()*3);
			boolean open_spot_computer = openSpotOnBoard(board,computer_row,computer_col);
			while (open_spot_computer == false) {
				computer_row = (int)(Math.random()*3);
				computer_col = (int)(Math.random()*3);
				open_spot_computer = openSpotOnBoard(board,computer_row,computer_col);
			}
			System.out.println("Computer chose, row: " + (computer_row+1) + " column: "+ (computer_col+1)); // printing the computer's choice for the user to see
			fillTheBoard(board,computer_row,computer_col,"X");
			printBoard(board);
			
			// VALIDATING IF ANYONE WON (COMPUTER, USER, OR TIE) and breaking out of the program as soon as an end result is found
			tie = isTie(board);
			winner = check(board);
			if (tie || winner.equals("USER")||winner.equals("COMPUTER")) {
				done = true; // setting the "main" controlling variable : done, to false (indicating that the game is over)
				if (winner.equals("USER")) {
					System.out.println(user_name + ", you WON!!!");
					break;
				}
				if (winner.equals("COMPUTER")) {
					System.out.println("COMPUTER WON!!!");
					break;
				}
				if (tie) {
					System.out.println("THERE IS A TIE");
					break;
				}
	
			}
		}
	
		 
	}
	
	//CHECKING ALL THE POSSIBLE WINNING OUTCOMES AND PASSING THOSE OUTCOMES TO checkVerification method to check
	static String check(String[][] board) {
		for (int row = 0; row < board.length;row++) { // checking rows
			String c = checkVerification(board[row][0],board[row][1],board[row][2]); 
			if (c.equals("USER"))
				return "USER";
			if (c.equals("COMPUTER"))
				return "COMPUTER";
		}
		for (int col = 0; col < board.length;col++) { // checking columns
			String c = checkVerification(board[0][col],board[1][col],board[2][col]);
			if (c.equals("USER"))
				return "USER";
			if (c.equals("COMPUTER"))
				return "COMPUTER";
		}
		// checking diagonals
		for (int i = 0; i < 1;i++) {
			String c = checkVerification(board[0][0],board[1][1],board[2][2]);
			if (c.equals("USER"))
				return "USER";
			if (c.equals("COMPUTER"))
				return "COMPUTER";
		}
		for (int i = 0; i < 1;i++) {
			String c = checkVerification(board[0][2],board[1][1],board[2][0]);
			if (c.equals("USER"))
				return "USER";
			if (c.equals("COMPUTER"))
				return "COMPUTER";
		}
		return "NONE";
		
	}
	
	//VERFYING IF THE THREE STRINGS ARE EQUAL
	static String checkVerification(String str1, String str2, String str3) {
		if (str1.equals("O")&&str2.equals("O")&&str3.equals("O"))
			return "USER";
		if (str1.equals("X")&&str2.equals("X")&&str3.equals("X"))
			return "COMPUTER";
		return "NONE";
		
	}
	//CHECKING IF THERE IS A TIE
	static boolean isTie(String[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col].equals("."))
					return false;
			}
		}
		return true;
	}
	//FINIDING IF THE SPOT ENTERED IS OPEN
	static boolean openSpotOnBoard(String[][] board, int row, int col) {
		if (board[row][col].equals("."))
				return true;
		return false;
	}

	
	//FILLING IN THE BOARD
	static void fillTheBoard(String[][] board, int row, int col, String str) {
		board[row][col] = str;
	}
	
	//PRINTING THE LAYOUT OF THE BOARD
	static void printBoard(String[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + "   ");
			}
			System.out.println();
		}
	}

}
