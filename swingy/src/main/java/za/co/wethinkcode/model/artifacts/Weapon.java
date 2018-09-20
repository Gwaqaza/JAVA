package za.co.wethinkcode.model.artifacts;

import java.util.Random;

public class Weapon extends Artifact {

    String weaponNames[] = {"Axe", "Sword", "Mace", "Great Sword", "Lance"};
    Random rand = new Random();

    public Weapon ()
    {
        super( 0);
        this.name = weaponNames[rand.nextInt(5)];
        boost = 0;
        this.type = "weapon";
    }

    public Weapon (int level)
    {
        this.level = level;
        this.name = weaponNames[rand.nextInt(5)];
        this.boost = rand.nextInt(10 * level);
        this.type = "weapon";
    }

    public Weapon (String name, int boost)
    {
        this.name = name;
        this.boost = boost;
    }
}
