package src.main.java;

import src.main.java.actions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private static final int X_MAX = 10;
    private static final int Y_MAX = 10;
    private static final int HERBIVORE_NUM = 4;
    private static final int PREDATOR_NUM = 2;
    private static final int GRASS_NUM = 11;
    private static final int ROCK_NUM = 6;
    private static final int TREE_NUM = 9;
    private final Map map;
    private int moveCount;
    private final SimCLI cli;
    private final ArrayList<Action> initActions;
    private final ArrayList<Action> turnActions;
    Simulation(){
        this.map = new Map(X_MAX, Y_MAX);
        this.moveCount = 0;
        this.cli = new SimCLI();
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
    }
    public void nextTurn(){}
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
        cli.renderTurn(map);
    }
    public void playSimRealTime(){
        cli.renderTurn(map);
    }
    public void createActions(){
        initActions.add(new GrassSpawnAction(GRASS_NUM));
        initActions.add(new RockSpawnAction(ROCK_NUM));
        initActions.add(new TreeSpawnAction(TREE_NUM));
        initActions.add(new HerbivoreSpawnAction(HERBIVORE_NUM));
        initActions.add(new PredatorSpawnAction(PREDATOR_NUM));

//        turnActions.add(new CreatureMoveAction());
    }
    public void pauseSim(){}

}
