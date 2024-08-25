package src.main.java;

public class Simulation {
    private final Map map;
    private int moveCount;
    private final SimCLI cli;
    Simulation(){
        this.map = new Map();
        this.moveCount = 0;
        this.cli = new SimCLI();
    }
    public void nextTurn(){}
    public void startSim(){}
    public void pauseSim(){}

}
