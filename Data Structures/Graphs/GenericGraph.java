import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class GenericGraph<E> {
    private final Map<E, List<E>> map = new HashMap<>();

    public void addVertex(E s) {
        map.put(s, new LinkedList<>());
    }

    public void addEdge(E source, E destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public void getVertexCount() {
        System.out.println("The graph has " + map.keySet().size() + " vertex");
    }

    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        for (E v : map.keySet()) {
            count += map.get(v).size();
        }

        if (bidirection) {
            count = count / 2;
        }

        System.out.println("The graph has " + count + " edges.");
    }

    public void hasVertex(E s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    public void hasEdge(E s, E d) {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else {
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (E v : map.keySet()) {
            builder.append(v.toString()).append("-> ");
            for (E w : map.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

    public static void main(String[] args) {
        GenericGraph<Integer> g = new GenericGraph<Integer>();

        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        System.out.println("Graph:\n" + g.toString());
        g.getVertexCount();
        g.getEdgesCount(true);
        g.hasEdge(3, 4);
        g.hasVertex(5);
    }
}

/*      OUTPUT:
        Graph:
        0-> 1 4
        1-> 0 2 3 4
        2-> 1 3
        3-> 1 2 4
        4-> 0 1 3

        The graph has 5 vertex
        The graph has 7 edges.
        The graph has an edge between 3 and 4.
        The graph does not contain 5 as a vertex.
 */
