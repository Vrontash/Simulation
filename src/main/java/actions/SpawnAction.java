package src.main.java.actions;

import src.main.java.Action;
import src.main.java.Coordinates;
import src.main.java.Entity;
import src.main.java.Map;

import java.util.Random;

abstract class SpawnAction<T extends Entity> extends Action {
    protected double rate;

    @Override
    public void perform(Map map) {
        double currentRate = 0;
        while (currentRate < rate) {
            Coordinates coordinates = getEmptyRandomCoordinates(map);
            map.addEntity(coordinates, spawnEntity(coordinates));
            currentRate++;
        }
    }

    private Coordinates getEmptyRandomCoordinates(Map map) {
        Coordinates coord;
        while (true){
            coord = new Coordinates(new Random().nextInt(map.xMax ), new Random().nextInt(map.yMax ));
            if (map.isCellEmpty(coord))
                return coord;
        }
    }


    protected abstract T spawnEntity(Coordinates c);
}