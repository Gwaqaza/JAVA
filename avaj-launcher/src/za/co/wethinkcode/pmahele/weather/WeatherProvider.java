package za.co.wethinkcode.pmahele.weather;

import za.co.wethinkcode.pmahele.simulator.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SNOW", "SUN"};

    private WeatherProvider() {}

    public static WeatherProvider getWeatherProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        int int_rand = 0;
        int_rand = rand.nextInt(4);
        return (weather[int_rand]);
    }
}
