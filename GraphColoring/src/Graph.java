/* Greedy graph coloring always colors a vertex with the smallest available color
such that that we have proper coloring
*/

import java.util.LinkedList;

public class Graph {

    private int numberOfVertices;
    private LinkedList<Integer>[] adjacentVertices;

    // create a constructor for the class GreedyColoring
    Graph(int n){
        numberOfVertices = n;
        adjacentVertices = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++){
            adjacentVertices[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        // undirected graph
        adjacentVertices[u].add(v);
        adjacentVertices[v].add(u);
    }

    public void GreedyColoring(){
        GreedyColoring.greedyColoring(numberOfVertices, adjacentVertices);
    }


}

