package za.co.wethinkcode.pmahele.simulator.vehicles;

import za.co.wethinkcode.pmahele.simulator.WeatherTower;
import za.co.wethinkcode.pmahele.weather.WriteFile;

public class Balloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Balloon (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                WriteFile.getWritefile().writeToFile("Balloon#" + this.name + "(" + this.id + "): What a blazing sunny day and I got shades.");
                break;
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                WriteFile.getWritefile().writeToFile("Balloon#" + this.name + "(" + this.id + "): I wish the balloon was covered with something.");
                break;
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                WriteFile.getWritefile().writeToFile("Balloon#" + this.name + "(" + this.id + "): I can't see anything, it's all white.");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                WriteFile.getWritefile().writeToFile("Balloon#" + this.name + "(" + this.id + "): It's so cold, I wish brought a warm jacket");
                break;
            default:
                WriteFile.getWritefile().writeToFile("Balloon#" + this.name + "(" + this.id + "): I can't connect the weather tower.");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            WriteFile.getWritefile().writeToFile("Balloon#" + this.name + "(" + this.id + ") landing.");
            WriteFile.getWritefile().writeToFile("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            this.weatherTower.unregisterTower(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.registerTower(this);
        WriteFile.getWritefile().writeToFile("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
