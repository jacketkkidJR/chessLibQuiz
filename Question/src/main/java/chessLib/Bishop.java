package chessLib;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure{
    private static final List<int[]> MOVES = new ArrayList<>();

    static {
        for (int i = 1; i < 8; i++) {
            MOVES.add(new int[]{i, i});
            MOVES.add(new int[]{i, -i});
            MOVES.add(new int[]{-i, -i});
            MOVES.add(new int[]{-i, i});
        }
    }

    public Bishop() {
        super();
    }

    public Bishop(Position position) {
        super(position);
    }

    @Override
    protected List<int[]> getMoves(){
        return MOVES;
    }

    @Override
    public String toString(){
        return "Bishop";
    }
}
