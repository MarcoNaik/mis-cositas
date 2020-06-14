package stuff.resources;

public class Insight extends AbstractResource {
    public Insight(int quantity) {
        super(quantity);
    }

    @Override
    public String getName() {
        return "Insight";
    }
}
