package stuff.resources;

public class Food extends AbstractResource {
    public Food(int quantity) {
        super(quantity);
    }

    @Override
    public String getName(){
        return "Food";
    }


}
