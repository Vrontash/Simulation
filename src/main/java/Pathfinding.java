package src.main.java;

import java.util.*;

public class Pathfinding {
    private static List<Coordinates> getObstacles(Map map, Class<?> typeOfFood){
        List<Coordinates> obstacles =new ArrayList<>();
        for (Coordinates coord: map.coordinatesSet())
            if (map.getEntity(coord).getClass() != typeOfFood)
                obstacles.add(coord);
        return obstacles;
    }
    public static List<Coordinates> getNeighbours(Map map, Coordinates coordinates, Class<?> typeOfFood){
        int x = coordinates.getX();
        int y = coordinates.getY();
        List<Coordinates> obstacles = getObstacles(map, typeOfFood);
        obstacles.remove(coordinates);
        List<Coordinates> neighbours = new ArrayList<>();
        neighbours.add(new Coordinates(x + 1, y));
        neighbours.add(new Coordinates(x - 1, y));
        neighbours.add(new Coordinates(x, y - 1));
        neighbours.add( new Coordinates(x, y + 1));
        for (Coordinates obst: obstacles)
            neighbours.remove(obst);
        neighbours.removeIf(neigh -> neigh.getX() < 0 || neigh.getX() > map.xMax - 1 || neigh.getY() < 0 || neigh.getY() > map.yMax - 1);
        return  neighbours;
    }
    public static List<Coordinates> BreadthFirstSearch(Map map, Coordinates from,  Class<?> typeOfFood){
        Queue<Coordinates> unvisited = new LinkedList<>();
        unvisited.add(from);
        List<Coordinates> foodList = new ArrayList<>();
        for(Coordinates coordinates: map.coordinatesSet())
            if (map.getEntity(coordinates).getClass() == typeOfFood)
                foodList.add(coordinates);
        HashMap<Coordinates, Coordinates> stepHistory = new HashMap<>();
        stepHistory.put(from, from);
        Coordinates nearestGrass = null;
        while (!unvisited.isEmpty()){
            Coordinates currentCoord = unvisited.poll();
            if (foodList.contains(currentCoord)){
                nearestGrass = currentCoord;
                break;
            }
            for (Coordinates next: getNeighbours(map, currentCoord,typeOfFood))
                if (!stepHistory.containsKey(next)){
                    unvisited.add(next);
                    stepHistory.put(next, currentCoord);
                }
        }
        return reconstructPath(stepHistory, from, nearestGrass);
    }
    public static List<Coordinates> reconstructPath(HashMap<Coordinates, Coordinates> stepHistory, Coordinates from, Coordinates to){
        Coordinates current = to;
        List<Coordinates> path = new ArrayList<>();
        if (!stepHistory.containsKey(to))
            return List.of();
        while (current != from){
            path.add(current);
            current = stepHistory.get(current);
        }
        path.add(from);
        Collections.reverse(path);
        return path;
    }
    public static Coordinates findNearestObject(Map map, Coordinates from, Class<?> searchedClass){
        double minDistance = Double.MAX_VALUE;
        Coordinates nearest = null;
        for (Coordinates to : map.coordinatesSet()) {
            if (to.equals(from)) continue;
            if (map.getEntity(to).getClass() != searchedClass) continue;
            double distance = findManhattanDistance(from, to);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = to;
            }
        }
        return nearest;
    }
    public static double findManhattanDistance(Coordinates from, Coordinates to){
        return Math.abs(from.getX() - to.getX())+ Math.abs(from.getY() - to.getY());
    }
}
