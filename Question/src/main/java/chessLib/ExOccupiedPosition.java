package chessLib;

public class ExOccupiedPosition extends Exception {
    public ExOccupiedPosition() { super("Position is occupied. Unable to add piece."); }

    public ExOccupiedPosition(String msg) { super(msg); }
}
