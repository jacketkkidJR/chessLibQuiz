package chessLib;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure{
    private static final List<int[]> MOVES = new ArrayList<>();

    static {
        for (int i = 1; i < 8; i++) {
            MOVES.add(new int[]{i, i});
            MOVES.add(new int[]{i, -i});
            MOVES.add(new int[]{-i, -i});
            MOVES.add(new int[]{-i, i});
            MOVES.add(new int[]{0, i});
            MOVES.add(new int[]{0, -i});
            MOVES.add(new int[]{i, 0});
            MOVES.add(new int[]{-i, 0});
        }
    }

    public Queen() {
        super();
    }

    public Queen(Position position) { super(position); }

    @Override
    protected List<int[]> getMoves(){
        return MOVES;
    }

    @Override
    public String toString(){
        return "Queen";
    }
}
