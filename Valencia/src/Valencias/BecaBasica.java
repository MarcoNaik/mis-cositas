package Valencias;

public class BecaBasica extends AbstractBeca {

    public BecaBasica(int monto, int cupo) {
        this.monto = monto;
        this.cupo = cupo;
    }

    @Override
    public String type() {
        return "basica";
    }
}
