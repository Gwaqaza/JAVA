package za.co.wethinkcode.model.artifacts;

import java.util.Random;

public class Armor extends Artifact {

    String armorNames[] = {"Fauld", "Plackard", "Corslet", "Cuirasse", "Brigandine"};
    Random rand = new Random();

    public Armor ()
    {
        super( 0);
        this.name = armorNames[rand.nextInt(5)];;
        boost = 0;
        this.type = "armor";
    }

    public Armor ( int level)
    {
        this.boost = rand.nextInt(10 * level);
        this.name = armorNames[rand.nextInt(5)];
        this.level = level;
        this.type = "armor";
    }

    public Armor (String name, int boost)
    {
        this.name = name;
        this.boost = boost;
    }
}
