package src.main.java;

public class SimCLI {

    public void prepMenu(){
        System.out.println("SIMULATION");
        System.out.println("To enter simulation in turn-based mode press T");
        System.out.println("To enter real-time simulation press R");
        System.out.println("    To pause simulation in real-time mode press P");
    }
    public void renderTurn(Map map){
        for (int y = 0; y < map.yMax; y++) {
            for (int x = 0; x < map.xMax; x++) {
                Coordinates coord = new Coordinates(x, y);
                if (map.isCellEmpty(coord))
                    System.out.print("\uD83D\uDFEB");
                else
                    System.out.print(map.getEntity(coord).toString());
            }
            System.out.println();
        }
    }
}
