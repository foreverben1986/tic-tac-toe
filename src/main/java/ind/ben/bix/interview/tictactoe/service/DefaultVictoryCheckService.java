package ind.ben.bix.interview.tictactoe.service;

import ind.ben.bix.interview.tictactoe.service.base.IVictoryCheck;
import org.springframework.stereotype.Service;

@Service
public class DefaultVictoryCheckService implements IVictoryCheck {

    public boolean checkVictory(int score) {
        boolean win = false;
        switch (score) {
            case 0b100100100:
            case 0b010010010:
            case 0b001001001:
            case 0b111000000:
            case 0b000111000:
            case 0b000000111:
            case 0b100010001:
            case 0b001010100:
                win =true;
        }
        return win;
    }
}
