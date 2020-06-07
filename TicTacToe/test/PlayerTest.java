import org.junit.Before;
import org.junit.Test;

import java.time.OffsetTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayerTest {

    Player XtestPlayer;
    Player OtestPlayer;

    @Before
    public void setUp(){
        XtestPlayer= new Player('X', "");
        OtestPlayer= new Player('O', "");
    }

    @Test
    public void CheckPlayers{
        assertNotEquals(XtestPlayer, OtestPlayer);
        assertEquals(XtestPlayer,new Player('X', ""));
        assertEquals(OtestPlayer,new Player('O', ""));
        XtestPlayer.Plays("c2");
        OtestPlayer.Plays("b2");
        assertEquals(XtestPlayer,new Player('X', "c2"));
        assertEquals(OtestPlayer,new Player('O', "b2"));

    }


}
