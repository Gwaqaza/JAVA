package za.co.wethinkcode.model.characters;

public class Warrior extends Hero {

    public Warrior()
    {
        super("Warrior");
    }

    public Warrior(String name)
    {
        super (name);
        this.type = "Warrior";
        this.attack += 5;
        this.defense += 10;

    }

    public Warrior(String name, int att, int def, int hp, int maxHp, int xp, int lvl)
    {
        this.setName(name);
        this.type = "Warrior";
        this.setAttack(att);
        this.setDefense(def);
        this.setHp(hp);
        this.setMaxHp(maxHp);
        this.setlvl(lvl);
        this.setXp(xp);
    }
}
