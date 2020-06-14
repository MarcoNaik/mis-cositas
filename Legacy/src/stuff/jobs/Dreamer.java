package stuff.jobs;
import stuff.resources.Insight;

public class Dreamer extends AbstractJob {

    private static IJob dreamerJob;
    private Dreamer(){}


    public static IJob getDreamerJob() {
        if (dreamerJob==null)  dreamerJob= new Dreamer();
        return dreamerJob;
    }

    @Override
    public void excecuteJob(int level) {
        addResources(new Insight(level));

    }

    @Override
    public String getNames() {
        return "Dreamers";
    }


}
