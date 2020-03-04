package no.hib.dat100.tictactoe;

public class GameController {

	private char[][] board;
	private char turn;

	// TODO: could consider defining an enumeration type for players

	public GameController() {
		turn = TicTacToe.X_PLAYER_CHR; // Player 'X' starts the game
		board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
	}

	public char getTurn() {
		return turn;
	}

	public void nextTurn() {
		switch (turn) {
		case TicTacToe.X_PLAYER_CHR:
			turn = TicTacToe.O_PLAYER_CHR;
			break;
		case TicTacToe.O_PLAYER_CHR:
			turn = TicTacToe.X_PLAYER_CHR;
			break;
		}
	}

	private boolean checkHorizontal(int y, char player) {
		
		boolean allequal = true;

		// TODO - START
		
		// return ((player == board[y][0]) && (player == board[y][1]) && (player == board[y][2]));
		for (int x=0;x<TicTacToe.SIZE;x++) { // could consider while-loop and stop earlier
			allequal = allequal && player == board[y][x];
		}
		
		// TODO - SLUTT
		
		return allequal;
	}

	private boolean checkVertical(int x, char player) {
		
		boolean allequal = true;
		
		// TODO - START
		
		// return ((player == board[x][0]) && (player == board[x][1]) && (player == board[x][2]));
		for (int y = 0; y<TicTacToe.SIZE; y++) {
			allequal = allequal && player == board[y][x];
		}
		
		// TODO - SLUTT
		return allequal;
	}

	private boolean checkDiagonals(char player) {
		
		
		boolean allequal_lr = true; // for checking left to right diagonal
		boolean allequal_rl = true; // for checking right to left diagonal
		
		// TODO - START
		
		// return ((player == board[0][0]) && (player == board[1][1]) && (player == board[2][2]))
	    //	   || ((player == board[0][2]) && (player == board[1][1]) && (player == board[2][0]));
		
		for (int i = 0; i<TicTacToe.SIZE; i++) {
			allequal_lr = allequal_lr && player == board[i][i];
		}
		
		for (int i = 0; i<TicTacToe.SIZE; i++) {
			allequal_rl = allequal_rl && player == board[i][TicTacToe.SIZE-1-i]; 
		}
	
		// TODO - SLUTT
		
		return allequal_lr || allequal_rl;
		
	}

	public boolean checkGameBoardPlayer(char player) {

		boolean gameover = false;

		// check all rows on the board (horizontal)
		int y = 0;
		while (!gameover && y < TicTacToe.SIZE) {

			gameover = checkHorizontal(y, player);
			y++;
		}

		// check all columns on the board (vertical)
		int x = 0;
		while (!gameover && x < TicTacToe.SIZE) {

			gameover = checkVertical(x, player);
			x++;
		}

		if (!gameover) {
			gameover = checkDiagonals(player);
		}

		return gameover;
	}

	// check board given that field (x,y) has been selected by player
	public char checkGameBoard(int x, int y, char player) {
		char winner = ' ';

		System.out.println("Updating Gameboard (" + x + "," + y + ") = "
				+ player);
		board[y][x] = player;

		System.out.println("Checking Gameboard");

		if (checkGameBoardPlayer(TicTacToe.X_PLAYER_CHR)) {
			winner = TicTacToe.X_PLAYER_CHR;
		} else if (checkGameBoardPlayer(TicTacToe.O_PLAYER_CHR)) {
			winner = TicTacToe.O_PLAYER_CHR;
		}

		System.out.println("Winner = " + winner);

		return winner;
	}
}
