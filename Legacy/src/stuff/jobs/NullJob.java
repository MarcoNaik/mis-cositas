package stuff.jobs;


public class NullJob extends AbstractJob {

    public static IJob nullJob;

    private NullJob(){}

    public static IJob getNullJob(){
        if(nullJob==null) nullJob = new NullJob();
        return nullJob;
    }

    @Override
    public void excecuteJob(int level) {

    }

    @Override
    public String getNames() {
        return "Idle Humans";
    }


}
