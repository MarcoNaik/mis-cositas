package stuff.ResourceManager;
import stuff.resources.IResource;

import java.util.Hashtable;

import static stuff.jobs.Dreamer.getDreamerJob;
import static stuff.jobs.Gatherer.getGathererJob;
import static stuff.jobs.Kitchener.getKitchenerJob;

public class ResourceManager{

    private static Hashtable<String,IResource> hashStorage = new Hashtable<>();


    private AddResourceHandler addResourceHandler = new AddResourceHandler(this);
    private GetResourceHandler getResourceHandler = new GetResourceHandler(this);

    public ResourceManager() {
        getGathererJob().addAddResourcesListener(addResourceHandler);
        getDreamerJob().addAddResourcesListener(addResourceHandler);
        getKitchenerJob().addAddResourcesListener(addResourceHandler);
        getKitchenerJob().addGetResourcesListener(getResourceHandler);
    }

    public Hashtable<String, IResource> getHashStorage() {
        return hashStorage;
    }

    public void addResource(IResource resource){
        String key = resource.getName();
        IResource storagedResource = hashStorage.get(key);

        if (storagedResource==null){
            hashStorage.put(key, resource);
        }
        else{
            storagedResource.setQuantity(storagedResource.getQuantity()+ resource.getQuantity());
        }
    }

    public static boolean isEnough(IResource resource){
        String key = resource.getName();
        IResource storagedResource = hashStorage.get(key);

        if (storagedResource==null) return false;

        return resource.getQuantity()<=storagedResource.getQuantity();

    }

    public void removeResource(IResource resource){
        String key = resource.getName();
        IResource storagedResource = hashStorage.get(key);

        if (storagedResource==null){
            //no hay de estas cosas lol
        }
        else{
            storagedResource.setQuantity(storagedResource.getQuantity() - resource.getQuantity());
        }

    }
}
