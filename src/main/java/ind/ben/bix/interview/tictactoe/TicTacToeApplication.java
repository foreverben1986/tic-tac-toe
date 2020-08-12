package ind.ben.bix.interview.tictactoe;

import ind.ben.bix.interview.tictactoe.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner {

    @Autowired
    private TicTacToeService service;

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.execute();
    }
}
