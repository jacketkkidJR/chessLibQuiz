package chessLib;

public class ExInvalidPosition extends Exception {
    public ExInvalidPosition() { super("Invalid position. Unable to add piece."); }

    public ExInvalidPosition(String msg) { super(msg); }
}
