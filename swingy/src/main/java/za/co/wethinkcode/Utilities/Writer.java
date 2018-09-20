package za.co.wethinkcode.Utilities;

import za.co.wethinkcode.model.characters.Hero;

import java.io.*;

public class Writer {

    public static PrintWriter writer = null;

    public void saveHero(Hero hero) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("test.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(hero.getName() + "," + hero.getType() + "," + hero.getAttack() + "," + hero.getDefense() + "," + hero.getHp() + "," + hero.getMaxHp() + "," + hero.getXp() + "," + hero.getLvl() + ","
                    + artifactString(hero));
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File specification error");
        }
        catch (Exception e) {
            System.out.println("Unrecognised symbols in file");
            e.printStackTrace();
        }
    }

    public String artifactString(Hero hero) {
        String string = "";

        if (hero.getHelm() != null) {
            string += hero.getHelm().getName() + "#" + hero.getHelm().getBoost() + ",";
        }
        else {
            string += "null,";
        }
        if (hero.getArmor() != null) {
            string += hero.getArmor().getName() + "#" + hero.getArmor().getBoost() + ",";
        }
        else {
            string += "null,";
        }
        if (hero.getWeapon() != null) {
            string += hero.getWeapon().getName() + "#" + hero.getWeapon().getBoost();
        }
        else {
            string += "null";
        }
        return string;
    }
}