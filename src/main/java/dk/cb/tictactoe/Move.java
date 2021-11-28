package dk.cb.tictactoe;

import lombok.Data;

@Data
public class Move {

    private String[] position;
    private double score;

    public Move(String[] position, double score) {
        this.position = position;
        this.score = score;
    }
}
