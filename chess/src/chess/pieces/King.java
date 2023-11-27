package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

        // Special move castling
        if (super.getMoveCount() == 0 && !chessMatch.isCheck()) {
            // Special move castling - king side rook
            Position posT1 = new Position(super.position.getRow(), super.position.getColumn() + 3);

            if (testRookCastling(posT1)) {
                Position p1 = new Position(super.position.getRow(), super.position.getColumn() + 1);
                Position p2 = new Position(super.position.getRow(), super.position.getColumn() + 2);

                if (super.getBoard().getPiece(p1) == null && super.getBoard().getPiece(p2) == null) {
                    mat[super.position.getRow()][super.position.getColumn() + 2] = true;
                }
            }

            // Special move castling - queen side rook
            Position posT2 = new Position(super.position.getRow(), super.position.getColumn() - 4);

            if (testRookCastling(posT2)) {
                Position p1 = new Position(super.position.getRow(), super.position.getColumn() - 1);
                Position p2 = new Position(super.position.getRow(), super.position.getColumn() - 2);
                Position p3 = new Position(super.position.getRow(), super.position.getColumn() - 3);

                if (super.getBoard().getPiece(p1) == null && super.getBoard().getPiece(p2) == null && super.getBoard().getPiece(p3) == null) {
                    mat[super.position.getRow()][super.position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) super.getBoard().getPiece(position);

        return p == null || p.getColor() != super.getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) super.getBoard().getPiece(position);

        return p instanceof Rook && p.getColor() == super.getColor() && p.getMoveCount() == 0;
    }

}
