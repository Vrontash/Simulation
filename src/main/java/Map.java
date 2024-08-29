package src.main.java;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Map {
    public int xMax;
    public int yMax;
    private final ConcurrentHashMap<Coordinates, Entity> map = new ConcurrentHashMap<>();
    public Map(int xMax, int yMax){
        this.xMax = xMax;
        this.yMax = yMax;

    }
    public void addEntity(Coordinates coord, Entity entity){
        map.put(coord, entity);
    }
    public void removeEntity(Coordinates coord){
        map.remove(coord);
    }
    public Entity getEntity(Coordinates coord){
        return map.get(coord);
    }
    public void moveEntity(Coordinates from, Coordinates to){
        Entity entity = getEntity(from);
        removeEntity(from);
        entity.setCoordinates(to.getX(),to.getY());
        addEntity(to, entity);
    }

    public boolean isCellEmpty(Coordinates coord){
        return !map.containsKey(coord);
    }
    public Set<Coordinates> coordinatesSet(){

        return map.keySet();
    }
}
