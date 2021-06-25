import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SequentialSearchST<Key, Value> {
    private int N;
    private Node first;

    private class Node {
        private final Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {

    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException();
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException();
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new ArrayDeque<>();
        for (Node x = first; x != null; x = x.next) {
            queue.add(x.key);
        }
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<Character, Integer> st = new SequentialSearchST<>();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int i=0;
        for (char key : s.toCharArray()) {
            if (key != ' ') st.put(key, i++);
        }
        for (char key : st.keys()) System.out.println(key + " " + st.get(key));
    }
}

 /*
        OUTPUT:
        S E A R C H E X A M P L E
        L 11
        P 10
        M 9
        X 7
        H 5
        C 4
        R 3
        A 8
        E 12
        S 0
  */
