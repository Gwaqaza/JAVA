package za.co.wethinkcode.Utilities;

import za.co.wethinkcode.model.characters.Hero;

public class Print {


    public void printDirections()
    {
        System.out.println("You can go: ");
        System.out.println("NORTH - 'w'");
        System.out.println("SOUTH - 's'");
        System.out.println("EAST - 'd'");
        System.out.println("WEST - 'a'");
        System.out.println("STATS - 'stat'");
        System.out.println("HINT - 'hint'");
        System.out.println("EXIT - exit");
    }

    public void printStats(Hero myHero)
    {
        System.out.println("\n");
        System.out.println("-----STATS-----");
        System.out.println("Name: " + myHero.getName());
        System.out.println("Class: " + myHero.getType());
        System.out.println("Health: " + myHero.getHp() + "/" + myHero.getMaxHp());
        System.out.println("Level: " + myHero.getLvl());
        System.out.println("XP: " + myHero.getXp() + "/" + myHero.neededXP);
        System.out.println("Attack: " + myHero.getAttack());
        System.out.println("Defense: " + myHero.getDefense());
        System.out.println("Artifact: " + myHero.getArtifact());
        System.out.println("---------------");
        System.out.println("\n");
    }

    public void printClasses()
    {
        System.out.println("Hmmm I see, you do seem to have potential, but you will need some training!\n");
        System.out.println("1. Druid - a mighty bear with vast health pools");
        System.out.println("2. Mage - gifted with the magic arts, capable of great damage");
        System.out.println("3. Warrior - a highly skilled fighter able to defend themselves in any situation");
    }

    public void sleep (long time)
    {
        try
        {
            Thread.sleep(time);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
