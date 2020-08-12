package ind.ben.bix.interview.tictactoe.service;

import ind.ben.bix.interview.tictactoe.service.base.IDroppableCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class DefaultDroppableCheck implements IDroppableCheck {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDroppableCheck.class);

    @Override
    public boolean checkDroppable(int col, int row, int score) {
        if (col > 3 || row > 3) {
            logger.error(String.format("Invalid position. col: %d, row: %d.", col, row));
            return false;
        }
        int offset = (col - 1) + (row - 1) * 3;
        int position = 1 << offset;
        if ((position & score) > 0) {
            logger.error(
                    String.format(
                            "The position has already been occupied. col: %d, row: %d.",
                            col,
                            row));
            return false;
        }

        return true;
    }
}
