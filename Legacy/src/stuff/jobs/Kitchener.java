package stuff.jobs;

import stuff.resources.CookedFood;
import stuff.resources.Food;
import stuff.resources.IResource;

public class Kitchener extends AbstractJob{

    public static IJob kitchenerJob;
    private Kitchener(){}


    public static IJob getKitchenerJob() {
        if (kitchenerJob ==null) kitchenerJob = new Kitchener();
        return kitchenerJob;
    }

    @Override
    public void excecuteJob(int level) {
        cooldown = level/3;
        boolean isEnough= getResources(new Food(1));
        if (isEnough) addResources(new CookedFood(1));
        else System.out.println("no habia suficiente comida");

    }

    @Override
    public String getNames() {
        return "Kitcheners";
    }
}
