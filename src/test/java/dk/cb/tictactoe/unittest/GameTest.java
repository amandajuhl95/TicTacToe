package dk.cb.tictactoe.unittest;

import dk.cb.tictactoe.Game;
import dk.cb.tictactoe.Move;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Unit")
public class GameTest {

    private Game game;
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private  ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        game = new Game();
    }

    private void provideInput(String data) {
        inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    public void printBoardWhenCallingPrintBoard() {
        game.printBoard();
        assertEquals(". . .\n. . .\n. . .", outputStream.toString().trim());
    }

    @Test
    public void mustPrintSymbolOnBoardWhenMakingHumanMove() {
        boolean result = game.makeHumanMove(7);
        assertTrue(result);
        assertEquals(". . .\n. . .\nO . .", outputStream.toString().trim());
    }

    @Test
    public void mustReturnInfoWhenFieldAlreadyIsFilled() {
        game.makeHumanMove(5);
        assertEquals(". . .\n. O .\n. . .", outputStream.toString().trim());

        boolean result = game.makeHumanMove(5);
        assertFalse(result);
        assertEquals(". . .\n. O .\n. . .\nSlot already taken. Re-enter slot number", outputStream.toString().trim());
    }

    @Test
    public void mustPrintSymbolOnBoardWhenMakingAIMove() {
        game.makeAIMove();
        assertEquals("X . .\n. . .\n. . .", outputStream.toString().trim());
    }

    @Test
    public void mustReturnWinnerCallingWonBy() {
        String[] fakeBoard = {"O", "O", "O", ".", ".", ".", ".", ".", "."};

        String winner = game.wonBy(fakeBoard);
        assertEquals("O", winner);
    }

    @Test
    public void mustReturnNullWhenNoWinnerIsFound() {
        String[] fakeBoard = {"O", "O", ".", ".", ".", "O", ".", "X", "X"};

        String winner = game.wonBy(fakeBoard);
        assertEquals(null, winner);
    }

    @Test
    public void mustReturnTieWhenNoEmptySlots() {
        String[] fakeBoard = {"O", "O", "X", "X", "O", "O", "O", "X", "X"};

        String winner = game.wonBy(fakeBoard);
        assertEquals("Tie", winner);
    }

    @Test
    public void mustReturnBestAnswerWheCallingMiniMax() {
        String[] emptyBoard = {".",".",".",".",".",".",".",".","."};

        Move bestMove = game.minimax(emptyBoard, "X", "X");
        String[] expected = {"X",".",".",".",".",".",".",".","."};

        assertArrayEquals(expected, bestMove.getPosition());
    }

    @Test
    public void playTheGameAndEndInTieWhenCallingStart() throws InterruptedException {

        String winner = game.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(5);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(3);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(4);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(8);

        assertEquals("Game ended it, it was a tie", winner);

    }


}
