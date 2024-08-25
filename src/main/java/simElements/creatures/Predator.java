package src.main.java.simElements.creatures;

import src.main.java.simElements.Creature;

public class Predator extends Creature {
    private final int power;
    public Predator(int x, int y) {
        super(x, y, 3, 3);
        this.power = 2;
    }

    @Override
    public void makemove() {

    }
}
