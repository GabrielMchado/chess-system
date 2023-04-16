package application;

import java.lang.annotation.Target;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class ProgramChess {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chess =  new ChessMatch();
		
		
		while(true) {
			UI.printBoard(chess.getPiece());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			ChessPiece capturedPiece = chess.performChessMove(source, target);
		}
		
	}

}
