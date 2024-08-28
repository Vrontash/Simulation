package src.main.java.actions;

import src.main.java.Coordinates;
import src.main.java.simElements.creatures.Herbivore;

public class HerbivoreSpawnAction extends SpawnAction<Herbivore> {
    public HerbivoreSpawnAction(int herbivoreNumber){
        super.rate = herbivoreNumber;
    }
    @Override
    protected Herbivore spawnEntity(Coordinates c) {
        return new Herbivore(c);
    }
}
