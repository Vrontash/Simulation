package src.main.java;

import java.util.HashMap;
import java.util.Set;

public class Map {
    public int xMax;
    public int yMax;
    private final HashMap<Coordinates, Entity> map = new HashMap<>();
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
        addEntity(to, entity);
    }

    public boolean isCellEmpty(Coordinates coord){
        return !map.containsKey(coord);
    }
    public Set<Coordinates> coordinatesSet(){
        return map.keySet();
    }
}
