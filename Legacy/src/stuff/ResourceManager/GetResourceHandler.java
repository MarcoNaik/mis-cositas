package stuff.ResourceManager;

import stuff.resources.IResource;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetResourceHandler implements PropertyChangeListener {
    ResourceManager resourceManager;

    public GetResourceHandler(ResourceManager resourceManager){
        this.resourceManager=resourceManager;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        resourceManager.removeResource((IResource)  evt.getNewValue());


    }
}
