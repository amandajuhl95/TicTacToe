package dk.cb.tictactoe;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {

        Game game = new Game();
        game.start();

        //SpringApplication.run(TicTacToeApplication.class, args);
    }

}
