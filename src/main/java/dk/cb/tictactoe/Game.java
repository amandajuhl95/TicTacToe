package dk.cb.tictactoe;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private String[] board;
    private String human = "O";
    private String AI = "X";
    private String winner = null;
    private int emptyCells;

    private Scanner in = new Scanner(System.in);

    public Game() {
        this.board = new String[9];
        Arrays.fill(board, ".");
        this.emptyCells = this.board.length;
    }

    public void printBoard() {
        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);
    }

    public boolean makeHumanMove(int index) {

        if(index >= 1 && index <= 9) {
            if(board[index-1].equals(".")) {

                board[index-1] = human;
                printBoard();
                return true;
            } else {
                System.out.println("Slot already taken. Re-enter slot number");
                return false;
            }
        } else {
            System.out.println("Slot needs to be between 1 and 9. Try again.");
            return false;
        }

    }

    public void makeAIMove() {
        Move best = minimax(board, AI, AI);
        board = best.getPosition();
        printBoard();
    }

    public String wonBy(String[] board) {

        for (int winnerCase = 0; winnerCase < 8; winnerCase++) {
            String line = null;

            switch (winnerCase) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        if (Arrays.asList(board).contains(".")) {
            return null;
        } else {
            return "Tie";
        }

    }

    public Move minimax(String[] board, String maxPlayer, String player) {

        String otherPlayer = player.equals("X") ? "O" : "X";
        List<String[]> moveList = new ArrayList<>();
        Move best;

        for(int i = 0; i < 8; i++) {
            if(board[i].equals(".")) {
                String[] newBoard = board.clone();
                newBoard[i] = player;
                moveList.add(newBoard);
            }
        }

        // first we want to check if the previous move is a winner
        if (otherPlayer.equals(wonBy(board))) {
            if(otherPlayer.equals(maxPlayer)) {
                return new Move(null, 1 * (moveList.size() + 1));
            } else {
                return new Move(null, -1 * (moveList.size() + 1));
            }

        } else if(moveList.size() == 0) {
            return new Move(null, 0);
        }

        if (player.equals(maxPlayer)) {
            best = new Move(null, Double.NEGATIVE_INFINITY); // each score should maximize
        } else {
            best = new Move(null, Double.POSITIVE_INFINITY); // each score should minimize
        }

        for (String[] possibleMove: moveList) {
            Move simMove = minimax(possibleMove, maxPlayer, otherPlayer ); //simulate a game after making that move
            simMove.setPosition(possibleMove); // this represents the move optimal next move

            if(player.equals(maxPlayer)) { //X is max player
                if(simMove.getScore() > best.getScore()) {
                    best = simMove;
                }
            } else {
                if(simMove.getScore() < best.getScore()) {
                    best = simMove;
                }
            }
        }
        return best;
    }

    public String start() {

        while (emptyCells > 0 && winner == null) {
            if(emptyCells % 2 == 1) {
                System.out.println("\nAI's turn: \n");
                makeAIMove();
            } else {
                boolean validMove = false;
                while(!validMove) {
                    System.out.print("\nYour turn. Please enter a slot (between 1 and 9): ");
                    int position = in.nextInt();
                    validMove = makeHumanMove(position);
                }
            }
            // Check if someone wins already, update the flag
            winner = wonBy(board);
            emptyCells = countEmptyCells(board);
        }
        return findWinner(winner);
    }

    public String findWinner(String winner) {

        String result = "";

        if(winner.equals("Tie")) {
            result = "Game ended, it was a tie";
        } else {
            result = "Game ended, the winner is " + winner;
        }

        System.out.println(result);
        return result;
    }

    public int countEmptyCells(String[] board) {
        // Count how many empty cells left
        int count = 0;
        for(String slot : board) {
            if(slot.equals(".")) {
                count++;
            }
        }
        return count;
    }


}


