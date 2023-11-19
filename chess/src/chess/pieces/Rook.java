package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return (super.getColor().equals(Color.BLACK)) ? "R" : "r";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[super.getBoard().getRows()][super.getBoard().getColumns()];

        Position p = new Position(0, 0);

        // Above
        p.setValues(super.position.getRow() - 1, super.position.getColumn());

        while (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }

        if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Left
        p.setValues(super.position.getRow(), super.position.getColumn() - 1);

        while (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }

        if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Right
        p.setValues(super.position.getRow(), super.position.getColumn() + 1);

        while (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }

        if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Below
        p.setValues(super.position.getRow() + 1, super.position.getColumn());

        while (super.getBoard().positionExists(p) && !super.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }

        if (super.getBoard().positionExists(p) && super.isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}
