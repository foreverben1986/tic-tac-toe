package ind.ben.bix.interview.tictactoe.model;

import ind.ben.bix.interview.tictactoe.TicTacToeApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

public class BoardContextTest extends TicTacToeApplicationTests {

    @Test
    public void testInit_default_shouldPass() {
        BoardContext board = new BoardContext();
        Assertions.assertEquals(0, board.getPlayer1Score());
        Assertions.assertEquals(0, board.getPlayer2Score());
    }

    @Test
    public void testdropPiece_validationPass_returnTrue() {
        BoardContext board = new BoardContext();
        Assertions.assertTrue(board.dropPiece(1, 1, 1));
        Assertions.assertEquals(0b000000001, board.getPlayer1Score());
        Assertions.assertEquals(0b000000000, board.getPlayer2Score());

        Assertions.assertTrue(board.dropPiece(2, 2, 2));
        Assertions.assertEquals(0b000000001, board.getPlayer1Score());
        Assertions.assertEquals(0b000010000, board.getPlayer2Score());

        Assertions.assertTrue(board.dropPiece(3, 3, 1));
        Assertions.assertEquals(0b100000001, board.getPlayer1Score());
        Assertions.assertEquals(0b000010000, board.getPlayer2Score());
    }

    @Test
    public void testdropPiece_validationFalse_returnFalse() {
        BoardContext board = new BoardContext();
        Assertions.assertTrue(board.dropPiece(1, 1, 1));
        Assertions.assertFalse(board.dropPiece(1, 1, 1));
        Assertions.assertFalse(board.dropPiece(1, 1, 2));
    }

    @Test
    public void testCheckPlayerWin__returnTrue() {
        BoardContext board = new BoardContext();
        Assertions.assertTrue(board.dropPiece(1, 1, 1));
        Assertions.assertFalse(board.checkPlayerWin(1));
        Assertions.assertTrue(board.dropPiece(1, 2, 1));
        Assertions.assertFalse(board.checkPlayerWin(1));
        Assertions.assertTrue(board.dropPiece(1, 3, 1));
        Assertions.assertTrue(board.checkPlayerWin(1));

        BoardContext board2 = new BoardContext();
        Assertions.assertTrue(board2.dropPiece(1, 1, 2));
        Assertions.assertFalse(board2.checkPlayerWin(2));
        Assertions.assertTrue(board2.dropPiece(1, 2, 2));
        Assertions.assertFalse(board2.checkPlayerWin(2));
        Assertions.assertTrue(board2.dropPiece(1, 3, 2));
        Assertions.assertTrue(board2.checkPlayerWin(2));
    }

}
