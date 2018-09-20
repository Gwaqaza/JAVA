package za.co.wethinkcode.pmahele.simulator;

import za.co.wethinkcode.pmahele.simulator.vehicles.AircraftFactory;
import za.co.wethinkcode.pmahele.simulator.vehicles.Flyable;
import za.co.wethinkcode.pmahele.weather.WriteFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;
import java.util.*;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();

    public static void main(String[] arg) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations< 0) {
                    System.out.println("Invalid simulations count" + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraftFactory(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    if (flyable != null)
                        flyables.add(flyable);
                }
                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changedWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("" + arg[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file" + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify simulation file");
        } catch (NumberFormatException e) {
                System.out.println("Not a valid number entered in file");
        } finally {
            WriteFile.getWritefile().close();
        }
    }
}
