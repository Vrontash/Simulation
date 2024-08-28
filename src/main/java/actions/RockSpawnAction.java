package src.main.java.actions;

import src.main.java.Coordinates;
import src.main.java.simElements.objects.Rock;

public class RockSpawnAction extends SpawnAction<Rock> {
    public RockSpawnAction(int rockNum) {
        super.rate = rockNum;
    }

    @Override
    protected Rock spawnEntity(Coordinates c) {
        return new Rock(c);
    }
}
