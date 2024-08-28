package src.main.java.simElements.creatures;

import src.main.java.Coordinates;
import src.main.java.simElements.Creature;

public class Predator extends Creature {
    private final int power;
    public Predator(Coordinates coord) {
        super(coord, 3, 3);
        this.power = 2;
    }

    @Override
    public void makemove() {

    }
    @Override
    public String toString(){
        return "\uD83D\uDC3A";
    }
}
