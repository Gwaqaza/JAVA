package za.co.wethinkcode.pmahele.simulator.vehicles;

import za.co.wethinkcode.pmahele.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public Coordinates getCoordinates();
    public void registerTower(WeatherTower weatherTower);
}
