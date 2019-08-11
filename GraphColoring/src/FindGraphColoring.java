public class FindGraphColoring {

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Coloring of the Graph is: ");

        graph.GreedyColoring();

    }
}
