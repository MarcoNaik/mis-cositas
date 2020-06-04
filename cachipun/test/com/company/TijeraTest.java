package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TijeraTest extends ManoTest {
    
    Tijera manoTest = new Tijera();

    @Override
    @Test
    void CheckPlays(){
        assertEquals(-1, manoTest.play(piedra));
        assertEquals(1, manoTest.play(papel));
        assertEquals(0, manoTest.play(tijera));
    }
    
}
