package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PapelTest extends ManoTest{
    
    Papel manoTest = new Papel();

    @Override
    @Test
    void CheckPlays(){
        assertEquals(1, manoTest.play(piedra));
        assertEquals(0, manoTest.play(papel));
        assertEquals(-1, manoTest.play(tijera));
    }
    
}
