package chess.pieces;

import java.io.PipedOutputStream;

import boardgame.Board;
import boardgame.PositionChessPiece;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(PositionChessPiece position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(PositionChessPiece position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean mat[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		PositionChessPiece p = new PositionChessPiece(0, 0);
		
		p.setValues(position.getRow() -1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() +1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() -1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() +1, position.getColumn() +1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() +1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() -1, position.getColumn() +1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow(), position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow(), position.getColumn() +1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			PositionChessPiece positionKIng = new PositionChessPiece(position.getRow(), position.getColumn() +3);
			if(testRookCastling(positionKIng)) {
				PositionChessPiece p1 = new PositionChessPiece(position.getRow(), position.getColumn() +1);
				PositionChessPiece p2 = new PositionChessPiece(position.getRow(), position.getColumn() +2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() +2] = true;
				}
			}
			PositionChessPiece positionRook = new PositionChessPiece(position.getRow(), position.getColumn() -4);
			if(testRookCastling(positionRook)) {
				PositionChessPiece p1 = new PositionChessPiece(position.getRow(), position.getColumn() -1);
				PositionChessPiece p2 = new PositionChessPiece(position.getRow(), position.getColumn() -2);
				PositionChessPiece p3 = new PositionChessPiece(position.getRow(), position.getColumn() -3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() -2] = true;
				}
			}
		}
		
		return mat;
		
	}
	
}
