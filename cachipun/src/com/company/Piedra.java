package com.company;

public class Piedra implements Mano{

    @Override
    public int play(Mano oponente) {
        return oponente.playPiedra(this);
    }

    @Override
    public int playTijera(Tijera tijera) {
        return -1;
    }

    @Override
    public int playPapel(Papel papel) {
        return 1;
    }

    @Override
    public int playPiedra(Piedra piedra) {
        return 0;
    }
}
