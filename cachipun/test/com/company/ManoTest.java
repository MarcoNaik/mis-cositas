package com.company;

public abstract class ManoTest {

    public Piedra piedra = new Piedra();
    public Tijera tijera = new Tijera();
    public Papel papel = new Papel();
    
    
    
    abstract void CheckPlays();
}
