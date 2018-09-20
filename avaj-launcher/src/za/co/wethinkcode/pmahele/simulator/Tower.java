package za.co.wethinkcode.pmahele.simulator;

import za.co.wethinkcode.pmahele.simulator.vehicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> landed = new ArrayList<Flyable>();

    public void registerTower(Flyable flyable) {
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregisterTower(Flyable flyable) {
        landed.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
        flyable.updateConditions();
        if(flyable.getCoordinates().getHeight() <= 0)
            landed.add(flyable);
        }
        observers.removeAll(landed);
    }
}
