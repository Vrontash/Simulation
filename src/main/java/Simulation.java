package src.main.java;

import src.main.java.actions.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private static final int X_MAX = 10;
    private static final int Y_MAX = 10;
    private static final int HERBIVORE_NUM = 6;
    private static final int PREDATOR_NUM = 2;
    private static final int GRASS_NUM = 11;
    private static final int ROCK_NUM = 6;
    private static final int TREE_NUM = 9;
    private final Map map;
    private int moveCount;
    private final SimCLI cli;
    private final ArrayList<Action> initActions;
    private final ArrayList<Action> turnActions;
    private boolean isSimOver = false;
    Simulation(){
        this.map = new Map(X_MAX, Y_MAX);
        this.moveCount = 0;
        this.cli = new SimCLI();
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
    }
    public void nextTurn(){
        cli.renderTurn(map, moveCount);
        Set<Coordinates> entitiesCoordinates = Set.copyOf(map.coordinatesSet());
        for (Action act : turnActions)
            act.perform(map);
        if (entitiesCoordinates.equals(map.coordinatesSet())) isSimOver = true;
        moveCount ++;
    }
    public void startSim(){
        cli.prepMenu();
        createActions();
        for (Action ac: initActions)
            ac.perform(map);

        Scanner sc = new Scanner(System.in);
        String inAction = sc.next().toLowerCase();
        while (inAction.length() != 1) {
            System.out.println("Enter only a letter");
            inAction = sc.next().toLowerCase();
        }
        switch (inAction){
            case "t":
                playSimTurnBased();
                break;
            case "r":
                playSimRealTime();
                break;
            default:
                System.out.println("Entered letter is not used in this program");
        }
    }
    public void playSimTurnBased(){
        Scanner sc = new Scanner(System.in);
        while(!isSimOver) {
            nextTurn();
            System.out.println("Press Enter to continue");
            sc.nextLine();
        }
        cli.renderEndMessage(moveCount);
    }
    public void playSimRealTime(){
        while(!isSimOver) {
            nextTurn();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cli.renderEndMessage(moveCount);
    }
    public void createActions(){
        initActions.add(new GrassSpawnAction(GRASS_NUM));
        initActions.add(new RockSpawnAction(ROCK_NUM));
        initActions.add(new TreeSpawnAction(TREE_NUM));
        initActions.add(new HerbivoreSpawnAction(HERBIVORE_NUM));
        initActions.add(new PredatorSpawnAction(PREDATOR_NUM));

        turnActions.add(new CreatureMoveAction());
    }
}
