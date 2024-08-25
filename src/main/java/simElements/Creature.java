package src.main.java.simElements;

import src.main.java.Entity;

public abstract class Creature extends Entity {
    private final int speed;
    private int hp;

    public Creature(int x, int y, int speed, int hp){
        super(x, y);
        this.speed = speed;
        this.hp = hp;
    }
    public abstract void makemove();
}
