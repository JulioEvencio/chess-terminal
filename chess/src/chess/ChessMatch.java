package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private final Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.getPiece(i, j);
            }
        }

        return mat;
    }

    private void initialSetup() {
        placeNewPiece(6, 'b', new Rook(board, Color.WHITE));
        placeNewPiece(8, 'e', new King(board, Color.BLACK));
        placeNewPiece(1, 'e', new King(board, Color.WHITE));
    }

    private void placeNewPiece(int row, char column, ChessPiece chessPiece) {
        board.placePiece(chessPiece, new ChessPosition(row, column).toPosition());
    }

}
