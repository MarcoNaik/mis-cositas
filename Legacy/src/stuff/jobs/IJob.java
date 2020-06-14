package stuff.jobs;

import stuff.resources.IResource;

import java.beans.PropertyChangeListener;

public interface IJob {
    void excecuteJob(int level);
    void addResources(IResource resource);
    boolean getResources(IResource resource);
    void addAddResourcesListener(PropertyChangeListener listener);
    void addGetResourcesListener(PropertyChangeListener listener);
    String getNames();
}
