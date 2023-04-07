package application;

import chess.ChessMatch;

public class ProgramChess {

	public static void main(String[] args) {
		
		
		ChessMatch chess =  new ChessMatch();
		UI.printBoard(chess.getPiece());
		
		
	}

}
