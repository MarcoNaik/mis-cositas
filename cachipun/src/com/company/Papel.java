package com.company;

public class Papel implements Mano {

    @Override
    public int play(Mano manos) {
        return manos.playPapel(this);
    }

    @Override
    public int playTijera(Tijera tijera) {
        return 1;
    }

    @Override
    public int playPapel(Papel papel) {
        return 0;
    }

    @Override
    public int playPiedra(Piedra piedra) {
        return -1;
    }


}
