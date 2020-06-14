package stuff.resources;

public abstract class AbstractResource implements IResource{

    protected int quantity;

    public int getQuantity() {
        return quantity;
    }

    public AbstractResource(int quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity<0){
            this.quantity=0;
            return;
        }
        this.quantity = quantity;
    }
}
