package chessLib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

class BishopTest {

    private GameBoard board;

    @BeforeEach
    void setUp() {
        board = new GameBoard();
    }

    @Test void BishopMoveFromInsideBoard() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(3, 3);
        Bishop bishop = new Bishop(position);

        board.addPiece(bishop);
        Collection<Position> moves = bishop.validMovesFor(position, board);

        assertNotNull(moves);
        assertFalse(moves.contains(position));
        assertEquals(11, moves.size());
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (position.x() - position.y() == move.x() - move.y()) ||
                    (position.x() + position.y() == move.x() + move.y())
            );
        }
    }

    @Test void BishopMoveFromCorner() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(1, 1);
        Bishop bishop = new Bishop(position);

        board.addPiece(bishop);
        Collection<Position> moves = bishop.validMovesFor(position, board);

        assertNotNull(moves);
        assertFalse(moves.contains(position));
        assertEquals(7, moves.size());
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (position.x() - position.y() == move.x() - move.y()) ||
                            (position.x() + position.y() == move.x() + move.y())
            );
        }
    }

    @Test void BishopMoveFromEdge() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(4, 8);
        Bishop bishop = new Bishop(position);

        board.addPiece(bishop);
        Collection<Position> moves = bishop.validMovesFor(position, board);

        assertNotNull(moves);
        assertFalse(moves.contains(position));
        assertEquals(7, moves.size());
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (position.x() - position.y() == move.x() - move.y()) ||
                            (position.x() + position.y() == move.x() + move.y())
            );
        }
    }

    @Test void BishopMoveToOccupiedPosition() throws ExInvalidPosition, ExOccupiedPosition {
        Position bishopPos = new Position(3, 3);
        Bishop bishop = new Bishop(bishopPos);

        Position knightPos = new Position(5, 5);
        Knight knight = new Knight(knightPos);

        Position queenPos = new Position(2, 4);
        Queen queen = new Queen(queenPos);


        board.addPiece(bishop);
        board.addPiece(knight);
        board.addPiece(queen);
        Collection<Position> moves = bishop.validMovesFor(bishopPos, board);

        assertNotNull(moves);
        assertEquals(9, moves.size());
        assertFalse(moves.contains(knightPos));
        assertFalse(moves.contains(queenPos));
        assertFalse(moves.contains(bishopPos));
        for (var move : moves) {
            assertTrue(move.x() > 0 && move.x() <= 8 && move.y() > 0 && move.y() <= 8);
            assertTrue(
                    (bishopPos.x() - bishopPos.y() == move.x() - move.y()) ||
                            (bishopPos.x() + bishopPos.y() == move.x() + move.y())
            );
        }
    }
}