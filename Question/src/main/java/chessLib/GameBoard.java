package chessLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a game board that holds pieces and manages their positions.
 */
public class GameBoard {
    private Figure[][] board;
    private List<Figure> pieces;

    public GameBoard() {
        board = new Figure[8][8];
        pieces = new ArrayList<>();
    }

    /**
     * Adds a piece to the specified position on a board.
     * @param piece the Figure to be added.
     * @throws ExInvalidPosition Exception to be thrown if the position of the figure is invalid.
     * @throws ExOccupiedPosition Exception to be thrown if the position of the figure is already occupied.
     */
    public void addPiece(Figure piece) throws ExInvalidPosition, ExOccupiedPosition {
        Position position = piece.getPosition();

        if (!isPositionValid(position))
            throw new ExInvalidPosition(String.format("Invalid position %s. Unable to add piece %s.",
                    position, piece));

        if (!isPositionEmpty(position))
            throw new ExOccupiedPosition(String.format("Position %s is occupied. Unable to add piece %s.",
                    position, piece));

        pieces.add(piece);
        board[position.x() - 1][position.y() - 1] = piece;
    }

    /**
     * Checks whether the position on a board is empty.
     * @param position Position to be checked.
     * @return true if the position is empty; false otherwise.
     */
    boolean isPositionEmpty(Position position) {
        if (isPositionValid(position)) {
            return board[position.x() - 1][position.y() - 1] == null;
        }

        return false;
    }

    /**
     * Checks whether the position on a board is valid (i.e., within the board boundaries).
     * @param position Position to be checked.
     * @return true if the position is valid; false otherwise.
     */
    boolean isPositionValid(Position position) {
        return position.x() >= 1 && position.x() <= 8 && position.y() >= 1 && position.y() <= 8;
    }

    /**
     * Selects one piece on a board randomly and randomly moves it to any empty position that is reachable
     * by the selected figure.
     */
    public void moveRandomPiece(){
        if (pieces.isEmpty()) {
            System.out.println("No pieces to move.");
            return;
        }

        Random random = new Random();
        Figure piece = pieces.get(random.nextInt(pieces.size()));
        Position position = piece.getPosition();

        List<Position> validMoves = piece.validMovesFor(position, this);

        System.out.printf("Piece selected to move: %s at position %s. ", piece, position);

        if (validMoves.isEmpty()) {
            System.out.println("Unable to move the selected piece as there are no valid moves.");
            return;
        }

        Position newPosition = validMoves.get(random.nextInt(validMoves.size()));
        board[position.x()-1][position.y()-1] = null;
        board[newPosition.x()-1][newPosition.y()-1] = piece;
        piece.setPosition(newPosition);

        System.out.printf("Successfully moved a piece to the position %s.\n", newPosition);
    }

    /**
     * Retrieves the figure at the specified position.
     * @param position Position to get the Figure.
     * @return Figure at the position if the position is valid and occupied; null otherwise.
     */
    public Figure getPiece(Position position) {
        if (isPositionValid(position)) {
            return board[position.x()-1][position.y()-1];
        }
        return null;
    }
}
