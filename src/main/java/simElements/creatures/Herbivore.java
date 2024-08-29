package src.main.java.simElements.creatures;

import src.main.java.Coordinates;
import src.main.java.Map;
import src.main.java.Pathfinding;
import src.main.java.simElements.Creature;
import src.main.java.simElements.objects.Grass;
import java.util.ArrayList;
import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coord) {
        super(coord, 1, 3);
    }

    @Override
    public void makemove(Map map) {
        if (super.isMoved()) return;
        else super.setMoved(true);
        List<Coordinates> grassList = new ArrayList<>();
        for(Coordinates coordinates: map.coordinatesSet())
            if (map.getEntity(coordinates).getClass() == Grass.class)
                grassList.add(coordinates);
        List<Coordinates> path = Pathfinding.BreadthFirstSearch(map, super.getCoordinates(), grassList);
        if (path.isEmpty()) return;
        path.removeFirst();
        if (path.size() <= super.getSpeed())
            eatGrass(path.getLast(), map);
        else
            moveToGrass(path, map);

     }
    @Override
    public String toString(){
        return "\uD83D\uDC13"; //Chicken emoji
    }
    private void eatGrass(Coordinates grassCoordinates, Map map){
        map.removeEntity(grassCoordinates);
        map.moveEntity(super.getCoordinates(), grassCoordinates);
    }
    private void moveToGrass(List<Coordinates> path, Map map){
        for (int i = 0; i<super.getSpeed(); i++){
            if (path.isEmpty()) break;
            map.moveEntity(super.getCoordinates(), path.getFirst());
            path.removeFirst();
        }
    }


}
