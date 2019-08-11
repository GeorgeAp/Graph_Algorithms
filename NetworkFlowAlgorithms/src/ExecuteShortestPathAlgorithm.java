import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// try the Shortest Path Algorithm
public class ExecuteShortestPathAlgorithm {

    public static void main(String[] args){

        // create the nodes
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        // add the adjacency and distance
        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        // assign nodes to graph
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        // run the Shortest Path Algorithm
        graph = ShortestPathAlgorithm.findShortestPathFromStartNode(graph, nodeA);

        System.out.println(graph);

    }
}
