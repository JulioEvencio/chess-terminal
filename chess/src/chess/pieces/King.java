package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return (super.getColor().equals(Color.BLACK)) ? "K" : "k";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[super.getBoard().getRows()][super.getBoard().getColumns()];

        return mat;
    }
}
