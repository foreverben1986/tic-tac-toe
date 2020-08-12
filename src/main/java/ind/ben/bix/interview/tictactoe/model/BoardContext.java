package ind.ben.bix.interview.tictactoe.model;

import ind.ben.bix.interview.tictactoe.service.DefaultDroppableCheck;
import ind.ben.bix.interview.tictactoe.service.DefaultVictoryCheckService;
import ind.ben.bix.interview.tictactoe.service.base.IDroppableCheck;
import ind.ben.bix.interview.tictactoe.service.base.IVictoryCheck;

public class BoardContext {

    private int player1Score;
    private int player2Score;
    private IVictoryCheck victoryCheck;
    private IDroppableCheck droppableCheck;


    public BoardContext() {
        this.player1Score = 0b000000000;
        this.player2Score = 0b000000000;
        this.victoryCheck = new DefaultVictoryCheckService();
        this.droppableCheck = new DefaultDroppableCheck();
    }

    public BoardContext(
            IVictoryCheck victoryCheck,
            IDroppableCheck droppableCheck) {
        this.player1Score = 0b000000000;
        this.player2Score = 0b000000000;
        this.victoryCheck = victoryCheck;
        this.droppableCheck = droppableCheck;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    private boolean isDropable(int col, int row) {
        return droppableCheck.checkDroppable(col, row, player1Score | player2Score);
    }

    public boolean dropPiece(int col, int row, int player) {
        if (isDropable(col, row)) {
            int offset = (col - 1) + (row - 1) * 3;
            int position = 1 << offset;
            if (player == 1) {
                player1Score |= position;
            } else {
                player2Score |= position;
            }
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        this.player1Score = 0b000000000;
        this.player2Score = 0b000000000;
    }

    public boolean checkPlayerWin(int player) {
        if (player == 1) {
            return victoryCheck.checkVictory(player1Score);
        } else {
            return victoryCheck.checkVictory(player2Score);
        }
    }
}
