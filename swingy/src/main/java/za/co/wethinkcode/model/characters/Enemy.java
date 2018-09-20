package za.co.wethinkcode.model.characters;

import java.util.Random;

public class Enemy extends Character {

    private String[] names = { "Goblin", "Orc", "Troll", "Drake", "Murloc" };

    public Enemy()
    {
        Random rand = new Random();
        String enemyType = names[rand.nextInt(5)];
        int enemyAttack = rand.nextInt(14) + 5;
        int enemyDefense = rand.nextInt(5) + 0;
        int enemyHP = rand.nextInt(50) + 23;
        this.name = enemyType;
        this.attack = enemyAttack;
        this.defense = enemyDefense;
        this.hitPoints = enemyHP;
        this.maxHp = enemyHP;
    }
}
