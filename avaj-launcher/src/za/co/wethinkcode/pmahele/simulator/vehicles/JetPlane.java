package za.co.wethinkcode.pmahele.simulator.vehicles;

import za.co.wethinkcode.pmahele.simulator.WeatherTower;
import za.co.wethinkcode.pmahele.weather.WriteFile;

public class JetPlane extends Aircraft implements Flyable {

    private static WeatherTower weatherTower;

    JetPlane (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                WriteFile.getWritefile().writeToFile("JetPlane#" + this.name + "(" + this.id + "): What a blazing sunny day and I got shades.");
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                WriteFile.getWritefile().writeToFile("JetPlane#" + this.name + "(" + this.id + "): I wish I knew it was going to rain.");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                WriteFile.getWritefile().writeToFile("JetPlane#" + this.name + "(" + this.id + "): I can't see anything, it's all white.");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                WriteFile.getWritefile().writeToFile("JetPlane#" + this.name + "(" + this.id + "): It's so cold, but the snow looks good from up here.");
                break;
            default:
                WriteFile.getWritefile().writeToFile("JetPlane#" + this.name + "(" + this.id + "): I can't connect the weather tower.");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            WriteFile.getWritefile().writeToFile("JetPlane#" + this.name + "(" + this.id + ") Landing.");
            WriteFile.getWritefile().writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " Unregistered from weather tower.");
            this.weatherTower.unregisterTower(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteFile.getWritefile().writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.registerTower(this);
    }
}
