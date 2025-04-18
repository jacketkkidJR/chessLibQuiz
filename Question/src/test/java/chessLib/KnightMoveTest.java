package chessLib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

class KnightMoveTest {
    @Test void KnightMoveFromInsideBoard() {
        var pos = new Position(3, 3);
        var knight = new KnightMove();

        var moves = knight.validMovesFor(pos);
        assertNotNull(moves);
        assertEquals(8, moves.size());

        for (var move : moves) {
            switch (Math.abs(move.x() - pos.x()))
            {
                case 1:
                    assertEquals(2, Math.abs(move.y() - pos.y()));
                    break;
                case 2:
                    assertEquals(1, Math.abs(move.y() - pos.y()));
                    break;
                default:
                    fail();
                    break;
            }
        }
    }

    @Test void KnightMoveFromCorner() {
        Position pos = new Position(1, 1);
        KnightMove knight = new KnightMove();

        Collection<Position> moves = knight.validMovesFor(pos);
        assertNotNull(moves);
        assertEquals(2, moves.size());

        Position[] possibles = { new Position(2, 3), new Position(3, 2)};
        for (Position position : moves) {
            assertTrue(Arrays.asList(possibles).contains(position));
        }
    }
}