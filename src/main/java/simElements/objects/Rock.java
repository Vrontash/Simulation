package src.main.java.simElements.objects;

import src.main.java.Coordinates;
import src.main.java.Entity;

public class Rock extends Entity {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public String toString(){
        return "\uD83E\uDEA8";
    }
}
