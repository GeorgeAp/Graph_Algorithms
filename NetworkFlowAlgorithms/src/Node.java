import java.util.*;

public class Node {

    private String name;

    private List<Node> shortestPath = new LinkedList<>(); // this will contains the shortest path found

    private Integer distance = Integer.MAX_VALUE; // set infinite distance

    Hashtable<Node, Integer> adjacentNodes = new Hashtable<>(); // map neighbouring nodes and the length between them

    public void targetNode(Node targetN, int distance){
        adjacentNodes.put(targetN, distance);
    }

    public Node(String name){
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Hashtable<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        //System.out.println(shortestPath);
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

}
