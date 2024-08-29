package src.main.java.simElements.creatures;

import src.main.java.Coordinates;
import src.main.java.Map;
import src.main.java.simElements.Creature;


public class Predator extends Creature {
    private final int power;
    public Predator(Coordinates coord) {
        super(coord, 2, 3, Herbivore.class);
        this.power = 2;
    }

    public void eatObject(Coordinates nearestHerbivore, Map map){
        if (map.getEntity(nearestHerbivore) instanceof Creature creature) {
            int hp = creature.getHP();
            if (hp < power){
                map.removeEntity(nearestHerbivore);
                map.moveEntity(super.getCoordinates(), nearestHerbivore);
            }
            else
                ((Creature) map.getEntity(nearestHerbivore)).setHP(hp - power);
        }
    }
    @Override
    public String toString(){
        return "\uD83D\uDC3A";
    }
}
