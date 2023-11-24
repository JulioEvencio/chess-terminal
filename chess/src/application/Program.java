package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!chessMatch.isCheckMate()) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch, captured);

                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(scanner);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(scanner);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }
                } catch (ChessException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
            }

            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
        }
    }

}
