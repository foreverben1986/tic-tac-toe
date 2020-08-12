package ind.ben.bix.interview.tictactoe.service;

import ind.ben.bix.interview.tictactoe.model.BoardContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TicTacToeService {

    private static final Logger logger = LoggerFactory.getLogger(TicTacToeService.class);

    public void execute() throws IOException {
        int player = 1;
        BoardContext boardContext = new BoardContext();
        while (true) {
            System.out.println(
                    String.format("%s drop piece.", player == 1 ? "Player1" : "Player2"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            if (StringUtils.isEmpty(inputStr) || inputStr.split(",").length != 2) {
                logger.error("Invalid input. Please input again.");
                continue;
            }
            String[] positionStr = inputStr.split(",");
            if (boardContext.dropPiece(Integer.parseInt(positionStr[0]), Integer.parseInt(positionStr[1]), player)) {
                    if (boardContext.checkPlayerWin(player)) {
                        System.out.println(
                                String.format("%s win.", player == 1 ? "Player1" : "Player2"));
                        break;
                    };
            } else {
                continue;
            }


            player = player == 1 ? 2: 1;
        }
    }
}
