package za.co.wethinkcode.controller;

import za.co.wethinkcode.Utilities.Print;
import za.co.wethinkcode.model.Map;
import za.co.wethinkcode.model.characters.*;
import za.co.wethinkcode.model.characters.Druid;
import za.co.wethinkcode.model.characters.Hero;
import za.co.wethinkcode.model.characters.Mage;
import za.co.wethinkcode.model.characters.Warrior;
import za.co.wethinkcode.view.Window;

import za.co.wethinkcode.Utilities.*;

import java.util.List;
import java.util.Scanner;

public class Game {

    Print utils = new Print();
    Scanner                     scan = new Scanner(System.in);
    Map                         map;
    static public int           guiOrCli = 0;

    public static void main(String args[]) throws Exception
    {
        try
        {
            if (args.length > 2)
            {
                System.out.println("You have entered too many arguments");
            }
            else {
                String temp = args[0];
                new Game(temp);

            }
        }
        catch (Exception e)
        {
            System.out.println("No arguments have been passed");
        }
    }

    public Game() {}
    
    public Game(String args)
    {
        String  name;
        int     type;

        Hero myHero = new Hero();
        Loadgame load = new Loadgame();
        
        if (args.equalsIgnoreCase("Cli"))
        {
            guiOrCli = 1;
            System.out.println("Welcome to the world!");
            System.out.println("Would you like to:");
            System.out.println("1.Create a character");
            System.out.println("2.Select a previous character");
            int charSel = scan.nextInt();
            scan = new Scanner(System.in);
            if (charSel == 1)
            {
                System.out.println("Please enter your name hero...");
                name = scan.nextLine();
                utils.printClasses();
                type = scan.nextInt();
                scan = new Scanner(System.in);
                myHero = classSelect(type, name);
                map = new Map(myHero);
                map.newLevel(myHero);
                utils.sleep(600);
                System.out.println("So you're " + myHero.getName() + " the " + myHero.getType() +", I wonder...will you be the one to save our world?");
            }
            else if (charSel == 2)
            {
                List<Hero> heros;
                heros = load.createHeros();
                System.out.println("Please select a hero:");
                int i = 1;
                for (Hero hero : heros)
                {
                    System.out.println(i + ". " + hero.getName());
                    i++;
                }
                int chosen = scan.nextInt();
                myHero = heros.get(chosen - 1);
                System.out.println(myHero.getName());
                map = new Map(myHero);
                map.newLevel(myHero);
            }
            scan = new Scanner(System.in);
            utils.sleep(1000);
            while (move(map, scan) != -1)
            {
                System.out.printf("Your position x:%d, y:%d\n", myHero.getXPos(), myHero.getYPos());
                map.checkCollision(myHero);
                if (myHero.getHp() == 0)
                {
                    System.out.println("You've Died :(");
                    break;
                }
                while (map.checkWin(myHero) == 0)
                    map.checkWin(myHero);
                if (map.inMap() == false)
                {
                    break;
                }
            }
        }
        else if (args.equalsIgnoreCase("Gui")) 
        {
            guiOrCli = 2;
            Window win = new Window();
            win.createWindow();
        }
        else
            System.out.println("Did you enter Gui or Cli?");
    }

    public int move( Map map , Scanner scan)
    {
        Hero myHero = map.getHero();
        utils.printDirections();

        String input = scan.nextLine();
        switch (input)
        {
            case "w":
                map.moveUp();
                break;
            case "s":
                map.moveDown();
                break;
            case "a":
                map.moveLeft();
                break;
            case "d":
                map.moveRight();
                break;
            case "stat":
                utils.printStats(myHero);
                break;
            case "hint":
                map.hint();
                break;
            case "exit":
                return - 1;
            default:
                System.out.println("\n Invalid input \n");
        }
        return 0;
    }

    public Hero classSelect(int type, String name)
    {
        switch (type) {
            case 1 :
                return new Druid(name);
            case 2:
                return new Mage(name);
            case 3:
                return new Warrior(name);
        }
        return new Hero(name);
    }
}
