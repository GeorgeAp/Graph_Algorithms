// This is an implementation of Dijkstra Algorithm

import java.security.KeyStore;
import java.util.*;

public class ShortestPathAlgorithm {

    public static Graph findShortestPathFromStartNode(Graph graph, Node startNode){
        startNode.setDistance(0);

        List<Node> removedNodes = new LinkedList<>();
        List<Node> activeNodes = new LinkedList<>();

        activeNodes.add(startNode);

        while (activeNodes.size() != 0){
            Node currentNode = getSmallestDistanceNode(activeNodes);
            activeNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacentPair: currentNode.getAdjacentNodes().entrySet()){
                Node adjacentNode = adjacentPair.getKey();
                Integer edgeWeight = adjacentPair.getValue();
                if (!removedNodes.contains(adjacentNode)){
                    minimumDistanceValue(adjacentNode, edgeWeight,currentNode);
                    activeNodes.add(adjacentNode);
                }
            }
            removedNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getSmallestDistanceNode(List<Node> activeNodes){
        Node smallestDistanceNode = null;
        int smallestDistance = Integer.MAX_VALUE;
        for (Node node : activeNodes){
            int nodeDistance = node.getDistance();
            if (nodeDistance < smallestDistance){
                smallestDistance = nodeDistance;
                smallestDistanceNode = node;
            }
        }
        return smallestDistanceNode;
    }

    private static void minimumDistanceValue(Node evalautionNode, Integer edgeWeight, Node currentNode){
        Integer currentDistance = currentNode.getDistance();
        if(currentDistance + edgeWeight < evalautionNode.getDistance()){
            evalautionNode.setDistance(currentDistance + edgeWeight);
            LinkedList<Node> shortedPath = new LinkedList<>(currentNode.getShortestPath());
            shortedPath.add(currentNode);
            evalautionNode.setShortestPath(shortedPath);
        }
    }


}
