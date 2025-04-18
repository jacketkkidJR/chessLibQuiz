package chessLib;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {

    private Position position;

    public Figure() {
        this.position = null;
    }

    public Figure(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Position> validMovesFor(Position pos, GameBoard board) {
        var result = new ArrayList<Position>();
        var MOVES = getMoves();
        for (var ms : MOVES) {
            var newX = pos.x() + ms[0];
            var newY = pos.y() + ms[1];
            Position newPos = new Position(newX, newY);

            if (!board.isPositionEmpty(newPos)){
                continue;
            }

            result.add(newPos);
        }

        return result;
    }

    protected abstract List<int[]> getMoves();
}
