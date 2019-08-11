/* This implements Dijkstra's single source shortest path algorithm
  More details about the algorithm in the link below:
  http://math.mit.edu/~rothvoss/18.304.3PM/Presentations/1-Melissa.pdf

 */

public class ShortestPath {

    static final int V = 9;

    /* Below is a utility function to find the vertex with minimum distance value,
    from the set of vertices not yet included in shortest path tree
     */
    int minimumDistance(int[] distance, Boolean[] sptSet){

        // initialise the minimum value
        int min  = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++){
            if(sptSet[v] == false && distance[v] <= min){
                min = distance[v];
                min_index = v;
            }
        }
        //System.out.println(min_index);
        return min_index;
    }

    // function to print solution
    void printSolution(int[] distance, int n){
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < n; i++){
            System.out.println(i + " to " + distance[i]);
        }
    }

    // The Dijkstra's algorithm is implemented below
    void singleSourceShortestPath(int[][] graph, int source){

        // Set the output array
        int[] distance = new int[V];

        Boolean[] sptSet = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // set distance at the source
        distance[source] = 0;

        // find the shortest path for all vertices
        for (int j = 0; j < V; j++){
            int minimumUnprocessedVertex = minimumDistance(distance, sptSet);

            // mark the vertex as processed
            sptSet[minimumUnprocessedVertex] = true;

            // update the distance value of the adjacent vertices
            for (int k = 0; k < V; k++){
                if (!sptSet[k] && graph[minimumUnprocessedVertex][k] != 0 &&
                        distance[minimumUnprocessedVertex] != Integer.MAX_VALUE &&
                        distance[minimumUnprocessedVertex] + graph[minimumUnprocessedVertex][k]
                                < distance[k]){
                    distance[k] = distance[minimumUnprocessedVertex] + graph[minimumUnprocessedVertex][k];

                }
            }
        }
        printSolution(distance, V);
    }
}
