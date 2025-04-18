package chessLib;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMove {
    public final static int[][] MOVES = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};

    public Collection<Position> validMovesFor(Position pos) {
        var result = new ArrayList<Position>();
        for (var ms : MOVES) {
            var newX = pos.x() + ms[0];
            var newY = pos.y() + ms[1];

            if (newX > 8 || newX < 1 || newY > 8 || newY < 1)
                continue;

            result.add(new Position(newX, newY));
        }

        return result;
    }
}