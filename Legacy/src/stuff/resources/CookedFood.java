package stuff.resources;

public class CookedFood extends AbstractResource {

    @Override
    public String getName(){
        return "Cooked Food";
    }

    public CookedFood(int quantity) {
        super(quantity);
    }
}
