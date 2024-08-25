package src.main.java;

public abstract class Entity {
    private final Coordinates coordinates;
    public Entity(Coordinates coordinates){
       this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }
}
