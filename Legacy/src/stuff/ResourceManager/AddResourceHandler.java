package stuff.ResourceManager;

import stuff.resources.IResource;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddResourceHandler implements PropertyChangeListener{
    ResourceManager resourceManager;

    public AddResourceHandler(ResourceManager resourceManager){
        this.resourceManager=resourceManager;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        resourceManager.addResource((IResource)  evt.getNewValue());
    }
}
