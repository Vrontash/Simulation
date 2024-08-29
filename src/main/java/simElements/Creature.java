package src.main.java.simElements;

import src.main.java.Coordinates;
import src.main.java.Entity;
import src.main.java.Map;
import src.main.java.Pathfinding;

import java.util.List;

public abstract class Creature extends Entity {
    private final int speed;
    private int hp;
    private boolean isMoved = false;
    private final Class<?> typeOfFood;
    public Creature(Coordinates coord, int speed, int hp, Class<?> typeOfFood){
        super(coord);
        this.speed = speed;
        this.hp = hp;
        this.typeOfFood = typeOfFood;
    }
    public int getSpeed(){ return speed;}

    public void makemove(Map map){
        if (isMoved()) return;
        else setMoved(true);
        List<Coordinates> path = Pathfinding.BreadthFirstSearch(map, super.getCoordinates(), getTypeOfFood());
        if (path.isEmpty()) return;
        path.removeFirst();
        if (path.size() <= getSpeed())
            eatObject(path.getLast(), map);
        else
            moveToObject(path, map);
    }
    public abstract void eatObject(Coordinates objectCoordinates, Map map);
    public void moveToObject(List<Coordinates> path, Map map){
        for (int i = 0; i<speed; i++){
            if (path.isEmpty()) break;
            map.moveEntity(super.getCoordinates(), path.getFirst());
            path.removeFirst();
        }
    }
    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public int getHP() {
        return hp;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }

    public Class<?> getTypeOfFood() {
        return typeOfFood;
    }
}
