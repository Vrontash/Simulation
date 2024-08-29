package src.main.java.simElements;

import src.main.java.Coordinates;
import src.main.java.Entity;
import src.main.java.Map;

public abstract class Creature extends Entity {
    private final int speed;
    private int hp;
    private boolean isMoved = false;
    public Creature(Coordinates coord, int speed, int hp){
        super(coord);
        this.speed = speed;
        this.hp = hp;
    }
    public int getSpeed(){ return speed;}
    public abstract void makemove(Map map);
    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }
}
