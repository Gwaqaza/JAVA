package za.co.wethinkcode.model.characters;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Character {

    @NotNull(message = "Name cannot be null")
    public              String name;
    @Min(value = 0, message = "Attack should be higher than 0")
    @Max(value = 200, message = "Attack cannot be higher than 200")
    protected int       attack;
    @Min(value = 0, message = "Defense should be higher than 0")
    @Max(value = 200, message = "Defense cannot be higher than 200")
    protected int       defense;
    @Min(value = 0, message = "Health should be higher than 0")
    @Max(value = 200, message = "Health cannot be higher than 200")
    protected int       hitPoints;
    protected int       maxHp;
    protected int       XPos;
    protected int       YPos;



    public Character(){}

    public Character(String name, int attack, int defense, int hitPoints, int maxHp) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.maxHp = maxHp;
    }

    public int  getAttack()
    {
        return this.attack;
    }

    public int  getDefense()
    {
        return this.defense;
    }

    public int  getHp()
    {
        return this.hitPoints;
    }

    public int  getMaxHp()
    {
        return this.maxHp;
    }

    public String getName()
    {
        return this.name;
    }

    public void     takeDmg(int val)
    {
        this.hitPoints -= val;
        if (this.hitPoints < 0)
            this.hitPoints = 0;
    }

    public int  getXPos()
    {
        return this.XPos;
    }

    public int  getYPos()
    {
        return this.YPos;
    }

    public void setXPos(int val)
    {
        this.XPos = val;
    }

    public void setYPos(int val)
    {
        this.YPos = val;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAttack(int att)
    {
        this.attack = att;
    }

    public void setDefense(int def)
    {
        this.defense = def;
    }

    public void setHp(int hp)
    {
        this.hitPoints = hp;
    }
    
    public void setMaxHp(int maxHp)
    {
        this.maxHp = maxHp;
    }

}
