package src.main.java.actions;

import src.main.java.simElements.objects.Tree;
import src.main.java.Coordinates;

public class TreeSpawnAction extends SpawnAction<Tree> {
    public TreeSpawnAction(int treeNum) {
        super.rate = treeNum;
    }

    @Override
    protected Tree spawnEntity(Coordinates c) {
        return new Tree(c);
    }
}
