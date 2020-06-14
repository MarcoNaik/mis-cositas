package stuff;

import stuff.ResourceManager.ResourceManager;
import stuff.jobs.IJob;
import stuff.resources.CookedFood;
import stuff.resources.Food;
import stuff.resources.Insight;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static stuff.jobs.Dreamer.getDreamerJob;
import static stuff.jobs.Gatherer.getGathererJob;
import static stuff.jobs.Kitchener.getKitchenerJob;
import static stuff.jobs.NullJob.getNullJob;


public class Game{
    public ResourceManager resourceManager;
    List<Human> Humans = new ArrayList<>(0);
    private Hashtable<IJob, Integer> hashJobs = new Hashtable<>();
    int time;

    private PropertyChangeSupport setJobsNotification = new PropertyChangeSupport(this);
    private PropertyChangeSupport updateResourcesNotification = new PropertyChangeSupport(this);


    public Hashtable<IJob, Integer> getHashJobs() {
        return hashJobs;
    }

    public void addUpdateResourcesNotificationListener(PropertyChangeListener listener){
        updateResourcesNotification.addPropertyChangeListener(listener);
    }

    public void addSetJobsNotificationListener(PropertyChangeListener listener){
        setJobsNotification.addPropertyChangeListener(listener);
    }


    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public Game() {
        this.resourceManager = new ResourceManager();
        for (int i = 0 ; i<5 ; i++) Humans.add(new Human());
        time=0;

        hashJobs.put(getKitchenerJob(), 0);
        hashJobs.put(getGathererJob(), 0);
        hashJobs.put(getDreamerJob(), 0);
        hashJobs.put(getNullJob(), 3);

        getResourceManager().getHashStorage().put("Food", new Food(0));
        getResourceManager().getHashStorage().put("Cooked Food", new CookedFood(0));
        getResourceManager().getHashStorage().put("Insight", new Insight(0));

    }

    public void everyBodyWork(){
        for(Human h : Humans){
            h.work();
        }
        updateResourcesNotification.firePropertyChange("WORK->UPDATE_RESOURCE", null, null);
    }

    public void setJob(IJob newJob){
        for(Human h : Humans){
            IJob oldJob = h.getJob();
            if (oldJob==getNullJob()){
                h.setJob(newJob);
                hashJobs.put(oldJob, hashJobs.get(oldJob)-1);
                hashJobs.put(newJob, hashJobs.get(newJob)+1);
                setJobsNotification.firePropertyChange("SET_NEW_JOB", oldJob, newJob);
                return;
            }
        }
    }

    public void remove(IJob oldJob) {
        IJob newJob = getNullJob();
        for(Human h : Humans){
            if (h.getJob() == oldJob){
                h.setJob(newJob);
                hashJobs.put(oldJob, hashJobs.get(oldJob)-1);
                hashJobs.put(newJob, hashJobs.get(newJob)+1);
                setJobsNotification.firePropertyChange("SET_NEW_JOB", oldJob, newJob);
                return;
            }
        }
    }
/*
    public static void main(String[] args) {

        Game game = new Game();

        Human humanTest=game.Humans.get(0);
        Human humanTest2=game.Humans.get(1);

        humanTest.setJob(getDreamerJob());
        System.out.println(humanTest.getJob().getClass().toString());

        humanTest.setJob(getKitchenerJob());
        System.out.println(humanTest.getJob().getClass().toString());

        humanTest.work();

        humanTest2.setJob(getGathererJob());
        humanTest2.work();

        humanTest.work();

        System.out.println(isEnough(new CookedFood(1)));

    }

 */

}
