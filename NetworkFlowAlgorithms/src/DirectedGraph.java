
public class DirectedGraph {

    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;


        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            // populated adjacency matrix
            for (int i = 0; i< vertices; i++){
                adjList[i] = new LinkedList<>();
            }
        }
    }
}