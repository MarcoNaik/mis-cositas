package stuff.jobs;

import stuff.resources.IResource;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static stuff.ResourceManager.ResourceManager.isEnough;

public abstract  class AbstractJob implements IJob {
    private PropertyChangeSupport addResourcesNotification = new PropertyChangeSupport(this);
    private PropertyChangeSupport getResourcesNotification = new PropertyChangeSupport(this);

    protected long cooldown = 1;

    public void addAddResourcesListener(PropertyChangeListener listener){
        addResourcesNotification.addPropertyChangeListener(listener);
    }
    public void addGetResourcesListener(PropertyChangeListener listener){
        getResourcesNotification.addPropertyChangeListener(listener);
    }

    public AbstractJob(){}

    @Override
    public void addResources(IResource resource) {
        addResourcesNotification.firePropertyChange("ADD_RESOURCE", null, resource);

    }

    public boolean getResources(IResource resource) {
        boolean isEnough = isEnough(resource);
        if (isEnough) getResourcesNotification.firePropertyChange("GET_RESOURCE", null, resource);
        return isEnough;
    }


}
