package src.main.java.simElements;

import src.main.java.Coordinates;
import src.main.java.Entity;

public abstract class Creature extends Entity {
    private final int speed;
    private int hp;

    public Creature(Coordinates coord, int speed, int hp){
        super(coord);
        this.speed = speed;
        this.hp = hp;
    }
    public abstract void makemove();
}
