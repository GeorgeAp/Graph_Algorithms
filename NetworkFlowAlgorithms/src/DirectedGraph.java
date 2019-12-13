import java.util.LinkedList;

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

        public void addEdge(int source, int destination){
            adjList[source].addFirst(destination);
        }

        public boolean isCycle(){
            boolean[] visited = new boolean[vertices];
            boolean[] recursiveArr = new boolean[vertices];

            // perform DepthFirstSearch from each vertex
            for (int i = 0; i < vertices; i++){
                if (isCycleUtil(i, visited, recursiveArr)){
                    return true;
                }
                return false;
            }

            public boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursiveArr){
                visited[vertex]  = true;
                recursiveArr[vertex] = true;

                // a recursive call to all adjacent vertices
                for (int i = 0; i < adjList[vertex].size(); i++){
                    // if not already visited
                    int adjVertex = adjList[vertex].get(i);
                    if(!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveArr)){
                        return true;
                    }
                    else if(recursiveArr[adjVertex]){
                        return true;
                    }

                    // if no cycle is found
                    recursiveArr[vertex] = false;
                    return false;
                }
            }

            public static void main(String[] args) {
                int vertices = 4;
                Graph graph = new Graph(vertices);
                graph.addEgde(0, 1);
                graph.addEgde(1, 2);
                graph.addEgde(2, 3);
                graph.addEgde(3, 1);
                boolean result = graph.isCycle();
                System.out.println("is Cycle present: " + result);
            }
        }
    }
}