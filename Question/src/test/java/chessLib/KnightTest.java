package chessLib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

class KnightTest {

    private GameBoard board;

    @BeforeEach
    void setUp() {
        board = new GameBoard();
    }

    @Test void KnightMoveFromInsideBoard() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(3, 3);
        Knight knight = new Knight(position);

        board.addPiece(knight);
        Collection<Position> moves = knight.validMovesFor(position, board);

        assertNotNull(moves);
        assertEquals(8, moves.size());

        for (var move : moves) {
            assertTrue((Math.abs(move.x() - position.x()) == 1 && Math.abs(move.y() - position.y()) == 2) ||
                    (Math.abs(move.x() - position.x()) == 2 && Math.abs(move.y() - position.y()) == 1));
        }
    }

    @Test void KnightMoveFromCorner() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(1, 1);
        Knight knight = new Knight(position);

        board.addPiece(knight);
        Collection<Position> moves = knight.validMovesFor(position, board);
        Position[] possibles = { new Position(2, 3), new Position(3, 2) };

        assertNotNull(moves);
        assertEquals(2, moves.size());
        for (Position pos : moves) {
            assertTrue(Arrays.asList(possibles).contains(pos));
        }
    }

    @Test void KnightMoveFromEdge() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(4, 8);
        Knight knight = new Knight(position);

        board.addPiece(knight);
        Collection<Position> moves = knight.validMovesFor(position, board);
        Position[] possibles = {
                new Position(3, 6),
                new Position(2, 7),
                new Position(5, 6),
                new Position(6, 7)
        };

        assertNotNull(moves);
        assertEquals(4, moves.size());
        for (Position pos : moves) {
            assertTrue(Arrays.asList(possibles).contains(pos));
        }
    }

    @Test void KnightMoveToOccupiedPosition() throws ExInvalidPosition, ExOccupiedPosition {
        Position knightPos = new Position(3, 3);
        Knight knight = new Knight(knightPos);

        Position bishopPos = new Position(2, 5);
        Bishop bishop = new Bishop(bishopPos);

        Position queenPos = new Position(4, 1);
        Queen queen = new Queen(queenPos);

        board.addPiece(knight);
        board.addPiece(bishop);
        board.addPiece(queen);
        Collection<Position> moves = knight.validMovesFor(knightPos, board);
        Position[] possibles = {
                new Position(1, 4),
                new Position(1, 2),
                new Position(2, 1),
                new Position(4, 5),
                new Position(5, 4),
                new Position(5, 2)
        };

        assertNotNull(moves);
        assertEquals(6, moves.size());
        assertFalse(moves.contains(knightPos));
        assertFalse(moves.contains(queenPos));
        assertFalse(moves.contains(bishopPos));

        for (Position pos : moves) {
            assertTrue(Arrays.asList(possibles).contains(pos));
        }
    }
}