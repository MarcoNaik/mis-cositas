import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class TictactoeTest {

    private Tictactoe game;

    @BeforeEach
    public void setUp(){
        game = new Tictactoe();
    }


    @Test
    public void CheckState(){
        assertEquals(' ', game.get('a', '1'));
        assertEquals(' ', game.get('c', '2'));
        game.set('c','2','X');
        game.set('c', '3', 'O');
        assertEquals('X', game.get('c', '2'));
        assertEquals('O', game.get('c','3'));

        assertFalse(game.inRange('d','4'));
        assertTrue(game.inRange('b','3'));
    }

    @Test public void testWinConditions() {
        checkGame("a1\nb2\nc3\n", "b1\nc1\n", "X", 4);
    }

    public void checkGame(String Xmoves, String Omoves, String winner, int squaresLeft) {
        Player X = new Player('X', Xmoves); // a scripted player
        Player O = new Player('O', Omoves);
        Tictactoe game = new Tictactoe(X, O);
        GameDriver.playGame(game);
        assertTrue(game.winner().name().equals(winner));
        assertTrue(game.squaresLeft() == squaresLeft);
    }



}
