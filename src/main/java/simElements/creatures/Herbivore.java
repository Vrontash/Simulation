package src.main.java.simElements.creatures;

import src.main.java.Coordinates;
import src.main.java.Map;
import src.main.java.simElements.Creature;
import src.main.java.simElements.objects.Grass;


public class Herbivore extends Creature {

    public Herbivore(Coordinates coord) {
        super(coord, 1, 3, Grass.class);
    }

    public void eatObject(Coordinates grassCoordinates, Map map){
        map.removeEntity(grassCoordinates);
        map.moveEntity(super.getCoordinates(), grassCoordinates);
    }
    @Override
    public String toString(){
        return "\uD83D\uDC13"; //Chicken emoji
    }


}
