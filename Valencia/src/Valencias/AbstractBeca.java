package Valencias;

public abstract class AbstractBeca implements IBeca{
    protected int monto;
    protected int cupo;

    @Override
    public int getMonto() {
        return monto;
    }

    @Override
    public int getCupo() {
        return cupo;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public abstract String type();

}
