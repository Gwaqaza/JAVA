package za.co.wethinkcode.model.characters;

public class Mage extends Hero{

    public Mage()
    {
        super("Mage");
    }

    public Mage(String name)
    {
        super(name);
        this.type = "Mage";
        this.attack += 12;
        this.defense += 2;
    }

    public Mage(String name, int att, int def, int hp, int maxHp, int xp, int lvl)
    {
        this.setName(name);
        this.type = "Mage";
        this.setAttack(att);
        this.setDefense(def);
        this.setHp(hp);
        this.setMaxHp(maxHp);
        this.setlvl(lvl);
        this.setXp(xp);
    }
}
