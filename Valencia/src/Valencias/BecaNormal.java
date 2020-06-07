package Valencias;

public class BecaNormal extends AbstractBeca {

    public BecaNormal(int monto, int cupo) {
        this.monto = monto;
        this.cupo = cupo;
    }

    @Override
    public String type() {
        return "normal";
    }
}
