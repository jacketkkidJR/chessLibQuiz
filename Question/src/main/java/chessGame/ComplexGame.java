package chessGame;

import chessLib.*;

import java.util.ArrayList;
import java.util.List;

public class ComplexGame extends BaseGame {

    private final GameBoard gameBoard;

    ComplexGame() {
        gameBoard = new GameBoard();
    }

    @Override
    public void setup() {
        List<Figure> input = new ArrayList<>();

        // Simply add necessary figures to the List named "input" by writing a line:
        // input.add(new {figure}(new Position({x, y coordinates of the position})));
        // Examples are given below:
        input.add(new Knight(new Position(1,1)));
        input.add(new Bishop(new Position(2,3)));
        input.add(new Queen(new Position(7,5)));
        input.add(new Knight(new Position(2,2)));
        input.add(new Queen(new Position(1,1)));

        // There is no need to modify this code
        for(Figure piece : input) {
            try {
                gameBoard.addPiece(piece);
                System.out.printf("0: Successfully added piece %s to the position %s.\n",
                        piece, piece.getPosition());
            } catch (Exception e) {
                System.out.println("0: " + e.getMessage());
            }
        }

    }

    @Override
    public void play(int moves) {
        for (int i = 1; i <= moves; i++) {
            System.out.printf("%d: ", i);
            gameBoard.moveRandomPiece();
        }
    }
}