package src.main.java.actions;

import src.main.java.Action;
import src.main.java.Coordinates;
import src.main.java.Map;
import src.main.java.simElements.Creature;

public class CreatureMoveAction extends Action {
    @Override
    public void perform(Map map) {
        for (Coordinates coord: map.coordinatesSet())
            if (map.getEntity(coord) instanceof Creature creature)
                creature.setMoved(false);
        for (Coordinates coord: map.coordinatesSet())
            if (map.getEntity(coord) instanceof Creature creature)
                creature.makemove(map);
    }
}
