package za.co.wethinkcode.model;

import za.co.wethinkcode.Utilities.Writer;
import za.co.wethinkcode.controller.Battle;
import za.co.wethinkcode.model.characters.*;
import za.co.wethinkcode.model.characters.Enemy;
import za.co.wethinkcode.model.characters.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Map {

    public List<Enemy> enemies  = new ArrayList<>();
    public int  mapX = 0;
    public int  mapY = 0;
    private boolean youWin = false;

    private static int enemyCount = 0;
    private Hero hero;

    public Map (Hero hero)
    {
        this.hero = hero;
    }

    public void moveUp()
    {
        hero.setYPos(hero.getYPos() - 1);
    }

    public void moveDown()
    {
        hero.setYPos(hero.getYPos() + 1);
    }

    public void moveLeft()
    {
        hero.setXPos(hero.getXPos() - 1);
    }

    public void moveRight()
    {
        hero.setXPos(hero.getXPos() + 1);
    }

    public Hero getHero()
    {
        return this.hero;
    }

    public void setHeroPos()
    {
        hero.setXPos(mapX/2);
        hero.setYPos(mapY/2);
    }

    public boolean inMap()
    {
        if (hero.getXPos() < 0 || hero.getXPos() > mapX)
            return false;
        else if (hero.getYPos() < 0 || hero.getYPos() > mapY)
            return false;
        return true;
    }

    public void enemyFarm()
    {
        Random rand = new Random();
        while (enemyCount < (hero.getLvl() * 3) + 1)
        {
            Enemy enemy = new Enemy();

            enemy.setXPos(rand.nextInt(mapX));
            enemy.setYPos(rand.nextInt(mapY));
            if (enemy.getXPos() != hero.getXPos() && enemy.getYPos() != hero.getYPos()) {
                enemies.add(enemy);
                enemyCount ++;
            }
            else
                enemyFarm();
        }
    }

    public void callEnemy()
    {
        for (Enemy enemy:enemies)
        {
            System.out.println(enemy.getName());
            System.out.println(enemy.getXPos());
            System.out.println(enemy.getYPos());
        }
    }

    public void checkCollision(Hero hero) {
        Enemy foundEnemy = null;
        for (Enemy enemy : enemies) {
            if (enemy.getXPos() == hero.getXPos() && enemy.getYPos() == hero.getYPos()) {
                foundEnemy = enemy;
            }
        }
        if (foundEnemy != null) {
            Battle fight = new Battle();
            int fightCheck = fight.fightCheck(hero, foundEnemy);
            while (fightCheck == 0) {
                fightCheck = fight.fightCheck(hero, foundEnemy);
            }
            if (fightCheck == 1) {
                int fightResult = fight.fight(hero, foundEnemy);
                if (fightResult == 0) {

                    //if you win the fight
                    enemies.remove(foundEnemy);
                } else if (fightResult == 1) {
                    //if you win the fight and level up
                    enemies.remove(foundEnemy);
                    newLevel(hero);
                }
            } else if (fightCheck == -1) {
                if (fight.run() == -1) {
                    if (fight.fight(hero, foundEnemy) == 1)
                        enemies.remove(foundEnemy);
                }
            }
        }
    }

    public void newLevel(Hero hero)
    {
        mapX = (hero.getLvl()-1)*5+10-(hero.getLvl()%2);
        mapY = mapX;
        setHeroPos();
        enemyCount = 0;
        enemyFarm();
    }

    public void hint()
    {
        for (Enemy enemy : enemies)
        {
            System.out.printf("\n");
            System.out.printf("Enemy %s\n", enemy.getName());
            System.out.printf("Position x:%d y:%d\n", enemy.getXPos(), enemy.getYPos());
            System.out.printf("\n");
            break;
        }
        System.out.printf("\n");
    }

    Scanner scan = new Scanner(System.in);
    public int checkWin(Hero hero)
    {
        Writer write = new Writer();


        if (inMap() == false)
        {
            System.out.println("Congratulations!!! You have won level " + hero.getLvl());
            System.out.println("would you like to save your progress? y/n");
            String save = scan.nextLine();
            scan = new Scanner(System.in);
            if (save.equalsIgnoreCase("Y"))
            {
                write.saveHero(hero);
                System.out.println("Saved!");
                this.youWin = true;
                return 1;
            }
            else if (save.equalsIgnoreCase("N"))
            {
                System.out.println("Bye bye!");
                return 2;
            }
            else
                return 0;
        }
        return 1;
    }
}
