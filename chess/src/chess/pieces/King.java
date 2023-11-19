package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

        Position p = new Position(0, 0);

        // Above
        p.setValues(super.position.getRow() - 1, super.position.getColumn());

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Below
        p.setValues(super.position.getRow() + 1, super.position.getColumn());

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Left
        p.setValues(super.position.getRow(), super.position.getColumn() - 1);

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Right
        p.setValues(super.position.getRow(), super.position.getColumn() + 1);

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // NW
        p.setValues(super.position.getRow() - 1, super.position.getColumn() - 1);

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // NE
        p.setValues(super.position.getRow() - 1, super.position.getColumn() + 1);

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SW
        p.setValues(super.position.getRow() + 1, super.position.getColumn() - 1);

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // SE
        p.setValues(super.position.getRow() + 1, super.position.getColumn() + 1);

        if (super.getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) super.getBoard().getPiece(position);

        return p == null || p.getColor() != super.getColor();
    }

}
