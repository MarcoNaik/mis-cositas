package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiedraTest extends ManoTest {

    Piedra manoTest = new Piedra();
    
    @Override
    @Test
    void CheckPlays(){
        assertEquals(0, manoTest.play(piedra));
        assertEquals(-1, manoTest.play(papel));
        assertEquals(1, manoTest.play(tijera));
    }
}
