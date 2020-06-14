package stuff;

import stuff.jobs.IJob;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GUIsetJobsHandler implements PropertyChangeListener {

    GUI gameGui;

    public GUIsetJobsHandler(GUI gameGui) {
        this.gameGui = gameGui;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        IJob oldJob = (IJob) evt.getOldValue();
        IJob newJob = (IJob) evt.getNewValue();

        gameGui.setJobs(oldJob, newJob);
    }
}
