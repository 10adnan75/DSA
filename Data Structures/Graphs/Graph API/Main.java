public class Main {

    public static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Ronaldo");
        graph.addVertex("Messi");
        graph.addVertex("Neymar");
        graph.addVertex("Ozil");
        graph.addVertex("Kaka");
        graph.addEdge("Ronaldo", "Messi");
        graph.addEdge("Ronaldo", "Ozil");
        graph.addEdge("Messi", "Neymar");
        graph.addEdge("Ozil", "Neymar");
        graph.addEdge("Messi", "Kaka");
        graph.addEdge("Ozil", "Kaka");
        return graph;
    }

    public static void main(String[] args) {
        Graph myGraph = createGraph();
        System.out.print("Graph:\n" + myGraph.printGraph());

        System.out.print("\nDFS: " + GraphTraversal.depthFirstTraversal(myGraph, "Ronaldo"));
        System.out.print("\nBFS: " + GraphTraversal.breadthFirstTraversal(myGraph, "Ronaldo"));
    }
}

/*  OUTPUT:
    Graph:
    Neymar-> [Messi, Ozil]
    Ozil-> [Ronaldo, Neymar, Kaka]
    Messi-> [Ronaldo, Neymar, Kaka]
    Kaka-> [Messi, Ozil]
    Ronaldo-> [Messi, Ozil]

    DFS: [Ronaldo, Ozil, Kaka, Messi, Neymar]
    BFS: [Ronaldo, Messi, Ozil, Neymar, Kaka]
 */
