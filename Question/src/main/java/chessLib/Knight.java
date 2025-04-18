package chessLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knight extends Figure{
    private static final List<int[]> MOVES = new ArrayList<>(Arrays.asList(
            new int[]{1, 2},
            new int[]{1, -2},
            new int[]{-1, 2},
            new int[]{-1, -2},
            new int[]{2, 1},
            new int[]{-2, 1},
            new int[]{2, -1},
            new int[]{-2, -1}
    ));

    public Knight() {
        super();
    }

    public Knight(Position position) { super(position); }

    @Override
    protected List<int[]> getMoves(){
        return MOVES;
    }

    @Override
    public String toString(){
        return "Knight";
    }
}
