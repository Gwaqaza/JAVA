package za.co.wethinkcode.model.characters;

import za.co.wethinkcode.model.artifacts.*;
import za.co.wethinkcode.model.artifacts.Armor;
import za.co.wethinkcode.model.artifacts.Helm;
import za.co.wethinkcode.model.artifacts.Weapon;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Hero extends Character {

    @Min(value = 0, message = "Min level is 0")
    @Max(value = 4, message = "Max level is 4")
    private int  lvl;
    @Min(value = 0, message = "Min XP is 0")
    private int  xp = 0;
    @Size(min = 4, max = 10, message 
      = "Type should be min 4(Mage) and max 7(Warrior)")
    protected String type;
    public int neededXP;

    private Helm helm;
    private Armor armor;
    private Weapon weapon;

    public Hero () {}

    public Hero(String name) {
        super (name, 15, 3, 100, 100);
        this.lvl = 1;
        this.xp = 0;
        this.neededXP = Math.abs((int) (this.lvl * 1000 + (Math.pow(this.lvl - 1 , 2) * 450)));
    }

    public Hero(String name, int attack, int defense, int hitPoints, int maxHp, int lvl, int xp) {
        super(name,attack, defense, hitPoints, maxHp);
        this.lvl = lvl;
        this.lvl = xp;
        this.neededXP = 0;
        this.neededXP = Math.abs((int) (this.lvl * 1000 + (Math.pow(this.lvl - 1 , 2) * 450)));
    }

    public int getLvl()
    {
        return this.lvl;
    }

    public int getXp()
    {
        return this.xp;
    }

    public String getType()
    {
        return this.type;
    }

    public int setXp(int val) {
        //System.out.println(this.neededXP);s
        this.xp += val;
        if (this.xp >= this.neededXP) {
            lvlUp(1);
            this.xp -= this.neededXP;
            this.neededXP = Math.abs((int) (this.lvl * 1000 + (Math.pow(this.lvl - 1 , 2) * 450)));
            return 1;
        }
        return 0;
    }

    public void setlvl(int lvl)
    {
        this.lvl = lvl;
    }

    public void setHelm(Helm helm) {
        if (this.helm != null)
            this.maxHp -= this.weapon.getBoost();
        this.helm = helm;
        this.maxHp += helm.getBoost();
    }

    public void setArmor(Armor armor) {
        if (this.armor != null)
            this.defense -= this.weapon.getBoost();
        this.armor = armor;
        this.defense += armor.getBoost();
    }

    public void setWeapon(Weapon weapon) {
        if (this.weapon != null)
            this.attack -= this.weapon.getBoost();
        this.weapon = weapon;
        this.attack += weapon.getBoost();
    }

    public Helm getHelm()
    {
        return this.helm;
    }

    public Armor getArmor()
    {
        return this.armor;
    }

    public Weapon getWeapon()
    {
        return this.weapon;
    }

    public void     lvlUp(int lvl) {
        this.lvl += lvl;
        //include growth stats
    }
    
        public String getArtifact() {
        if (helm != null) {
            return helm.getName();
        }
        else if (armor != null) {
            return armor.getName();
        }
        else if (weapon != null) {
            return weapon.getName();
        }
        else {
            return "none";
        }
    }
}