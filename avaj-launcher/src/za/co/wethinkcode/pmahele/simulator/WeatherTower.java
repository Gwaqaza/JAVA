package za.co.wethinkcode.pmahele.simulator;

import za.co.wethinkcode.pmahele.simulator.vehicles.Coordinates;
import za.co.wethinkcode.pmahele.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }

    void changedWeather() {
        this.conditionsChanged();
    }
}
