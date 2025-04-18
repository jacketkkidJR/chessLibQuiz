package chessLib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

class QueenTest {

    private GameBoard board;

    @BeforeEach
    void setUp() {
        board = new GameBoard();
    }

    @Test void BishopMoveFromInsideBoard() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(3, 3);
        Queen queen = new Queen(position);

        board.addPiece(queen);
        Collection<Position> moves = queen.validMovesFor(position, board);

        assertNotNull(moves);
        assertEquals(25, moves.size());
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (position.x() - position.y() == move.x() - move.y()) ||
                            (position.x() + position.y() == move.x() + move.y()) ||
                            position.x() == move.x() ||
                            position.y() == move.y()
            );
        }
    }

    @Test void BishopMoveFromCorner() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(1, 1);
        Queen queen = new Queen(position);

        board.addPiece(queen);
        Collection<Position> moves = queen.validMovesFor(position, board);

        assertNotNull(moves);
        assertEquals(21, moves.size());
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (position.x() - position.y() == move.x() - move.y()) ||
                            (position.x() + position.y() == move.x() + move.y()) ||
                            position.x() == move.x() ||
                            position.y() == move.y()
            );
        }
    }

    @Test void BishopMoveFromEdge() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(4, 8);
        Queen queen = new Queen(position);

        board.addPiece(queen);
        Collection<Position> moves = queen.validMovesFor(position, board);

        assertNotNull(moves);
        assertEquals(21, moves.size());
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (position.x() - position.y() == move.x() - move.y()) ||
                            (position.x() + position.y() == move.x() + move.y()) ||
                            position.x() == move.x() ||
                            position.y() == move.y()
            );
        }
    }

    @Test void BishopMoveToOccupiedPosition() throws ExInvalidPosition, ExOccupiedPosition {
        Position queenPos = new Position(3, 3);
        Queen queen = new Queen(queenPos);

        Position knightPos = new Position(5, 5);
        Knight knight = new Knight(knightPos);

        Position bishopPos = new Position(2, 4);
        Bishop bishop = new Bishop(bishopPos);

        Position queenVerticalPos = new Position(3, 1);
        Queen queenVertical = new Queen(queenVerticalPos);

        Position queenHorizontalPos = new Position(7, 3);
        Queen queenHorizontal = new Queen(queenHorizontalPos);

        board.addPiece(queen);
        board.addPiece(knight);
        board.addPiece(bishop);
        board.addPiece(queenVertical);
        board.addPiece(queenHorizontal);
        Collection<Position> moves = queen.validMovesFor(queenPos, board);

        assertNotNull(moves);
        assertEquals(21, moves.size());
        assertFalse(moves.contains(knightPos));
        assertFalse(moves.contains(queenPos));
        assertFalse(moves.contains(bishopPos));
        assertFalse(moves.contains(queenHorizontalPos));
        assertFalse(moves.contains(queenVerticalPos));
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (queenPos.x() - queenPos.y() == move.x() - move.y()) ||
                            (queenPos.x() + queenPos.y() == move.x() + move.y()) ||
                            queenPos.x() == move.x() ||
                            queenPos.y() == move.y()
            );
        }
    }
}