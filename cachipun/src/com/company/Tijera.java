package com.company;

public class Tijera implements Mano {


    @Override
    public int play(Mano manos) {
        return manos.playTijera(this);
    }

    @Override
    public int playTijera(Tijera tijera) {
        return 0;
    }

    @Override
    public int playPapel(Papel papel) {
        return -1;
    }

    @Override
    public int playPiedra(Piedra piedra) {
        return 1;
    }
}
