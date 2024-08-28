package src.main.java.simElements.creatures;

import src.main.java.Coordinates;
import src.main.java.simElements.Creature;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coord) {
        super(coord, 1, 3);
    }

    @Override
    public void makemove() {

    }
    @Override
    public String toString(){
        return "\uD83D\uDC13"; //Chicken emoji
    }
}
