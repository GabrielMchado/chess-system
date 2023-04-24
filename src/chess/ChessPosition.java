package chess;

import boardgame.PositionChessPiece;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPossition. Valid values are from a1 to h8");		
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected PositionChessPiece toPosition() {
		return new PositionChessPiece(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(PositionChessPiece position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
