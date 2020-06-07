package Valencias;

public class BecaAlta extends AbstractBeca{

    public BecaAlta(int monto, int cupo) {
        this.monto = monto;
        this.cupo = cupo;
    }

    @Override
    public String type() {
        return "alta";
    }
}
