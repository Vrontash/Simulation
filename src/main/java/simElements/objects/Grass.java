package src.main.java.simElements.objects;

import src.main.java.Coordinates;
import src.main.java.Entity;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public String toString(){
        return "\uD83C\uDF31";
    }
}
