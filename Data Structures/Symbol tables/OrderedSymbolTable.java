import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class OrderedSymbolTable<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private final TreeMap<Key, Value> ST;

    public OrderedSymbolTable() {
        ST = new TreeMap<>();
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return ST.get(key);
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) {
            ST.remove(key);
        } else {
            ST.put(key, val);
        }
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        ST.remove(key);
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("calls remove() with null key");
        ST.remove(key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return ST.containsKey(key);
    }

    public int size() {
        return ST.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return ST.keySet();
    }

    @Deprecated
    public Iterator<Key> iterator() {
        return ST.keySet().iterator();
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return ST.firstKey();
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return ST.lastKey();
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        Key k = ST.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("argument to ceiling() is too large");
        return k;
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        Key k = ST.floorKey(key);
        if (k == null) throw new NoSuchElementException("argument to floor() is too small");
        return k;
    }

    public static void main(String[] args) {
        OrderedSymbolTable<Character, Integer> st = new OrderedSymbolTable<>();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int i=0;
        for (char key : s.toCharArray()) {
            if (key != ' ') st.put(key, i++);
        }
        for (char key : st.keys()) System.out.println(key + " -> " + st.get(key));
    }
}

/*
        OUTPUT:
        A D N A N
        A -> 3
        D -> 1
        N -> 4
*/
