package za.co.wethinkcode.pmahele.simulator.vehicles;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++(Aircraft.idCounter);
    }

    public	Coordinates getCoordinates() { return this.coordinates; }
}
