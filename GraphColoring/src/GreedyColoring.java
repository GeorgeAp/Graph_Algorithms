/* Greedy graph coloring always colors a vertex with the smallest available color
   such that that we have proper coloring
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GreedyColoring {

    public static void greedyColoring(int numberOfVertices, LinkedList<Integer>[] adjacent){

        // create results array
        int[] result = new int[numberOfVertices];

        // Initialise all vertices as unassigned
        Arrays.fill(result, -1);

        // Assign the first color the the first vertex
        result[0] = 0;

        /* A temporary array to store the available colors. False
           value of available[cr] would mean that the color cr is
           assigned to one of its adjacent vertices
         */

        Boolean[] available = new Boolean[numberOfVertices];
        Arrays.fill(available, false);

        // Assign colors to the remain vertices
        for (int j = 0; j < numberOfVertices; j++){
            //Process all adjacent vertices and flag their colors and flag their colors as unavailable
            Iterator<Integer> iter = adjacent[j].iterator();
            while (iter.hasNext()){
                int i = iter.next();
                if (result[i] != -1){
                    available[result[i]] = false;
                }
            }

            // find the first available color
            int availableColor;
            for (availableColor = 0; availableColor < numberOfVertices -1; availableColor++){
                if (available[availableColor])
                    break;
            }
            // assign the found color
            result[j] = availableColor;

            // reset the values for available colors to true for next iteration
            Arrays.fill(available, true);
        }

        // print the results
        for (int k = 0; k < numberOfVertices; k++){
            System.out.println("Vertex " + k + " is colored ---> "+ result[k]);
        }
    }
}
