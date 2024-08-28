package src.main.java.simElements.objects;

import src.main.java.Coordinates;
import src.main.java.Entity;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public String toString(){
        return "\uD83C\uDF33";
    }
}
