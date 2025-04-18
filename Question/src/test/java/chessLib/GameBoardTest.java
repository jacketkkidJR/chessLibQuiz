package chessLib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard();
    }

    @Test void TestAddPieceValidPosition() throws ExInvalidPosition, ExOccupiedPosition{
        gameBoard.addPiece(new Knight(new Position(1, 1)));
        gameBoard.addPiece(new Knight(new Position(4, 4)));
        gameBoard.addPiece(new Knight(new Position(8, 8)));

        for (int i = 1; i <= 8; i++)
            for (int j = 1; j <= 8; j++)
                if ((i == 1 && j == 1) || (i == 4 && j == 4) || (i == 8 && j == 8))
                    assertFalse(gameBoard.isPositionEmpty(new Position(i, j)));
                else
                    assertTrue(gameBoard.isPositionEmpty(new Position(i, j)));

    }

    @Test void TestAddPieceInvalidPosition(){
        assertThrows(ExInvalidPosition.class, () -> {
            gameBoard.addPiece(new Knight(new Position(0, 0)));
        });
        assertThrows(ExInvalidPosition.class, () -> {
            gameBoard.addPiece(new Knight(new Position(2, 9)));
        });
        assertThrows(ExInvalidPosition.class, () -> {
            gameBoard.addPiece(new Knight(new Position(9, 3)));
        });
        assertThrows(ExInvalidPosition.class, () -> {
            gameBoard.addPiece(new Knight(new Position(-1, 10)));
        });

        for (int i = 1; i <= 8; i++)
            for (int j = 1; j <= 8; j++)
                assertTrue(gameBoard.isPositionEmpty(new Position(i, j)));

    }

    @Test void TestAddPieceOccupiedPosition() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(5, 5);
        Knight knight = new Knight(position);

        gameBoard.addPiece(knight);

        assertThrows(ExOccupiedPosition.class, () -> {
            gameBoard.addPiece(new Queen(position));
        });
        assertFalse(gameBoard.isPositionEmpty(position));
        assertEquals(knight, gameBoard.getPiece(position));
    }

    @Test void TestIsValidPositionEmpty() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(3, 3);

        assertTrue(gameBoard.isPositionEmpty(position));
    }

    @Test void TestIsInvalidPositionEmpty() throws ExInvalidPosition, ExOccupiedPosition {
        assertFalse(gameBoard.isPositionEmpty(new Position(0, 0)));
        assertFalse(gameBoard.isPositionEmpty(new Position(9, 9)));
        assertFalse(gameBoard.isPositionEmpty(new Position(-1, 10)));
    }

    @Test void TestMoveRandomPieceNoPieces() {
        gameBoard.moveRandomPiece();
    }

    @Test void TestMoveRandomPieceOnce() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(3,3);
        Knight knight = new Knight(position);

        gameBoard.addPiece(knight);
        gameBoard.moveRandomPiece();
        int count = 0;
        for(int i = 1; i <= 8; i++)
            for (int j = 1; j <= 8; j++)
                if (!gameBoard.isPositionEmpty(new Position(i, j)))
                    count++;

        assertEquals(1, count);
        assertTrue(gameBoard.isPositionEmpty(position));
    }

    @Test void TestGetPieceValidPosition() throws ExInvalidPosition, ExOccupiedPosition {
        Position position = new Position(1, 1);
        Knight knight = new Knight(position);

        gameBoard.addPiece(knight);

        assertEquals(knight, gameBoard.getPiece(position));
    }

    @Test void TestGetPieceInvalidPosition() {
        assertNull(gameBoard.getPiece(new Position(0, 0)));
        assertNull(gameBoard.getPiece(new Position(9, 9)));
        assertNull(gameBoard.getPiece(new Position(-1, 10)));
    }

}
