package stuff.jobs;
import stuff.resources.Food;

public class Gatherer extends AbstractJob {

    public static IJob gathererJob;
    private Gatherer(){}

    public static IJob getGathererJob() {
        if (gathererJob==null) gathererJob = new Gatherer();
        return gathererJob;
    }

    @Override
    public void excecuteJob(int level) {
        addResources(new Food(level));
    }

    @Override
    public String getNames() {
        return "Gatherers";
    }

}
