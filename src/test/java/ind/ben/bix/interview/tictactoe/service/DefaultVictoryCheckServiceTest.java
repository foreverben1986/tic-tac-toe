package ind.ben.bix.interview.tictactoe.service;

import ind.ben.bix.interview.tictactoe.TicTacToeApplicationTests;
import ind.ben.bix.interview.tictactoe.service.base.IVictoryCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultVictoryCheckServiceTest extends TicTacToeApplicationTests {

    @Autowired
    private IVictoryCheck defaultVictoryCheckService;

    private static int[] winScores;

    @BeforeAll
    public static void beforeAll() {
        winScores = new int[8];
        winScores[0] = 0b100100100;
        winScores[1] = 0b010010010;
        winScores[2] = 0b001001001;
        winScores[3] = 0b111000000;
        winScores[4] = 0b000111000;
        winScores[5] = 0b000000111;
        winScores[6] = 0b100010001;
        winScores[7] = 0b001010100;
    }

    @Test
    public void testCheckVictory_winScore_returnTrue() {
        for (int score : winScores) {
            Assertions.assertTrue(defaultVictoryCheckService.checkVictory(score));
        }
    }

    @Test
    public void testCheckVictory_other_returnFalse() {
        Assertions.assertFalse(defaultVictoryCheckService.checkVictory(0b1101011011101));
    }
}
