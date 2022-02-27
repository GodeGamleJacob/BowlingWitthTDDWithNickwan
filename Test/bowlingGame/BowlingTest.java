package bowlingGame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingTest {

    private Game game;

    private void rollMany(int balls, int pins) {
        for (int i = 0; i < balls; i++) game.roll(pins);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

}