package src.main.java.actions;

import src.main.java.Coordinates;
import src.main.java.simElements.creatures.Predator;

public class PredatorSpawnAction extends SpawnAction<Predator> {
    public PredatorSpawnAction(int predatorNum) {
        super.rate = predatorNum;
    }

    @Override
    protected Predator spawnEntity(Coordinates c) {
        return new Predator(c);
    }
}
