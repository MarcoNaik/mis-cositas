package stuff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import stuff.jobs.IJob;
import stuff.resources.IResource;

import static stuff.jobs.Dreamer.getDreamerJob;
import static stuff.jobs.Gatherer.getGathererJob;
import static stuff.jobs.Kitchener.getKitchenerJob;
import static stuff.jobs.NullJob.getNullJob;


public class GUI extends Application{

    Game elJUEGO;


    GUIsetJobsHandler guIsetJobsHandler;
    GUIupdateResourcesHandler guIupdateResourcesHandler;


    Label idleHumans;
    Label dreamerHumans;
    Label gathererHumans;
    Label kitchenerHumans;

    Label Food ;
    Label CookedFood ;
    Label Insight;

    VBox leftMenu = new VBox();
    HBox topMenu = new HBox();

    HBox rightMenu = new HBox();

    GridPane workersMenu = new GridPane();
    GridPane resourcesMenu = new GridPane();

    BorderPane borderPane = new BorderPane();


    @Override
    public void start(Stage primaryStage) throws Exception {
        elJUEGO = new Game();

        //set GUI as Subscriber of UpdateResourse and SetJob notifications
        guIsetJobsHandler = new GUIsetJobsHandler(this);
        guIupdateResourcesHandler = new GUIupdateResourcesHandler(this);
        elJUEGO.addUpdateResourcesNotificationListener(guIupdateResourcesHandler);
        elJUEGO.addSetJobsNotificationListener(guIsetJobsHandler);

        //set Workers and Resource Labels
        updateWorkerLabels();
        updateResourceLabels();

        //workers menu buttons
        Button addDreamer = new Button("Add dreamer");
        Button addKitchener = new Button("Add kitchener");
        Button addGatherer = new Button("Add gatherer");

        Button removeDreamer = new Button("Remove dreamer");
        Button removeKitchener = new Button("Remove kitchener");
        Button removeGatherer = new Button("Remove gatherer");

        //switch menu buttons
        Button gotoResourcesScene = new Button("Resources");
        Button gotoWorkScene = new Button("Workers");

        Button workButton = new Button("LETS GET SOME\nWORK DONE BITCH");
        workButton.setPrefSize(200,100);

        // building up pane panels
        rightMenu.getChildren().add(workButton);
        leftMenu.getChildren().addAll(addDreamer, removeDreamer, addGatherer, removeGatherer, addKitchener, removeKitchener);
        topMenu.getChildren().addAll(gotoResourcesScene, gotoWorkScene);

        leftMenu.setSpacing(10);
        topMenu.setSpacing(100);

        //building up pane
        borderPane.setLeft(leftMenu);
        borderPane.setTop(topMenu);
        borderPane.setRight(rightMenu);
        borderPane.setCenter(workersMenu);

        //Buttons actions

        gotoResourcesScene.setOnAction(e -> borderPane.setCenter(resourcesMenu));
        gotoWorkScene.setOnAction(e -> borderPane.setCenter(workersMenu));

        addDreamer.setOnAction(e->elJUEGO.setJob(getDreamerJob()));
        removeDreamer.setOnAction(e->elJUEGO.remove(getDreamerJob()));
        addKitchener.setOnAction(e->elJUEGO.setJob(getKitchenerJob()));
        removeKitchener.setOnAction(e->elJUEGO.remove(getKitchenerJob()));
        addGatherer.setOnAction(e->elJUEGO.setJob(getGathererJob()));
        removeGatherer.setOnAction(e->elJUEGO.remove(getGathererJob()));

        workButton.setOnAction(e->elJUEGO.everyBodyWork());

        primaryStage.setTitle("ELJUEGO EL JUEGO");
        primaryStage.setScene(new Scene(borderPane, 500, 275));
        primaryStage.show();
    }

    private void updateWorkerLabels() {
        idleHumans = getLabel(getNullJob());
        dreamerHumans = getLabel(getDreamerJob());
        gathererHumans = getLabel(getGathererJob());
        kitchenerHumans = getLabel(getKitchenerJob());

        GridPane auxPane = workersMenu;
        workersMenu = new GridPane();
        workersMenu.addColumn(1 ,idleHumans, dreamerHumans , gathererHumans ,kitchenerHumans);
        if (borderPane.getCenter() == auxPane) borderPane.setCenter(workersMenu);
    }
    public void updateResourceLabels(){

        Food = getResourceLabel("Food");
        CookedFood = getResourceLabel("Cooked Food");
        Insight = getResourceLabel("Insight");
        GridPane auxPane = resourcesMenu;

        resourcesMenu = new GridPane();
        resourcesMenu.addColumn(1, Food, Insight, CookedFood);
        if( borderPane.getCenter() == auxPane) borderPane.setCenter(resourcesMenu);
    }


    Label getLabel(IJob ajob){
        return new Label(ajob.getNames() + " : "+ elJUEGO.getHashJobs().get(ajob));
    }

    Label getResourceLabel(String resource){
        return new Label(resource + " : "+ elJUEGO.getResourceManager().getHashStorage().get(resource).getQuantity());
    }


    public static void main(String[] args) {
        launch(args);
    }


    public void setJobs(IJob oldJob, IJob newJob) {
        updateWorkerLabels();
    }
}