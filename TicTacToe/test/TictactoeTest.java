import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class TictactoeTest {

    private Tictactoe game;

    @Before
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



}
