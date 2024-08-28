package src.main.java.actions;

import src.main.java.Coordinates;
import src.main.java.simElements.objects.Grass;

public class GrassSpawnAction extends SpawnAction<Grass> {
    public GrassSpawnAction(int grassNum) {
        super.rate = grassNum;
    }

    @Override
    protected Grass spawnEntity(Coordinates c) {
        return new Grass(c);
    }
}
