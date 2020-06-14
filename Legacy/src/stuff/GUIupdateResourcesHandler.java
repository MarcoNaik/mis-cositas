package stuff;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GUIupdateResourcesHandler implements PropertyChangeListener {


    GUI gameGui;

    public GUIupdateResourcesHandler(GUI gameGui) {
        this.gameGui = gameGui;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameGui.updateResourceLabels();
    }
}
