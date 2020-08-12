package ind.ben.bix.interview.tictactoe.service;

import ind.ben.bix.interview.tictactoe.TicTacToeApplicationTests;
import ind.ben.bix.interview.tictactoe.service.base.IDroppableCheck;
import ind.ben.bix.interview.tictactoe.service.base.IVictoryCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultDroppableCheckTest extends TicTacToeApplicationTests {

    @Autowired
    private IDroppableCheck defaultDroppableCheck;

    @Test
    public void testCheckDroppable_occupied_returnFalse() {
        int board = 0b100010101;
        Assertions.assertFalse(defaultDroppableCheck.checkDroppable(1, 1, board));
        Assertions.assertFalse(defaultDroppableCheck.checkDroppable(3, 1, board));
        Assertions.assertFalse(defaultDroppableCheck.checkDroppable(2, 2, board));
        Assertions.assertFalse(defaultDroppableCheck.checkDroppable(3, 3, board));
    }

    @Test
    public void testCheckDroppable_notOccupied_returnTrue() {
        int board = 0b100010101;
        Assertions.assertTrue(defaultDroppableCheck.checkDroppable(2, 1, board));
        Assertions.assertTrue(defaultDroppableCheck.checkDroppable(1, 2, board));
        Assertions.assertTrue(defaultDroppableCheck.checkDroppable(3, 2, board));
        Assertions.assertTrue(defaultDroppableCheck.checkDroppable(1, 3, board));
        Assertions.assertTrue(defaultDroppableCheck.checkDroppable(2, 3, board));
    }

    @Test
    public void testCheckDroppable_colRowExceedScope_returnFlase() {
        int board = 0b100010101;
        Assertions.assertFalse(defaultDroppableCheck.checkDroppable(4, 1, board));
        Assertions.assertFalse(defaultDroppableCheck.checkDroppable(1, 4, board));
    }
}

