import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N = 0;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Key[] tempK = (Key[]) new Comparable[capacity];
        Value[] tempV = (Value[]) new Object[capacity];
        for (int i=0; i<N; i++) {
            tempK[i] = keys[i];
            tempV[i] = vals[i];
        }
        vals = tempV;
        keys = tempK;
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
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException();

        int lo = 0, hi = N-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException();

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (N == keys.length) resize(2 * keys.length);

        for (int j=N; j>i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;

        assert check();
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) return;

        int i = rank(key);

        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j=i; j<N-1; j++) {
            keys[j] = keys[j+1];
            vals[i] = vals[j+1];
        }

        N--;
        keys[N] = null;
        vals[N] = null;

        if (N > 0 && N == keys.length / 4) resize(keys.length / 2);

        assert check();
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException();
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException();
        delete(max());
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException();
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        return keys[N-1];
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        return keys[k];
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException();
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) throw new NoSuchElementException();
        return keys[i-1];
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException();
        int i = rank(key);
        if (i == N) throw new NoSuchElementException();
        return keys[i];
    }

    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException();
        if (hi == null) throw new IllegalArgumentException();

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        return rank(hi) - rank(lo);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException();
        if (hi == null) throw new IllegalArgumentException();

        Queue<Key> queue = new ArrayDeque<>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i=rank(lo); i<rank(hi); i++) queue.add(keys[i]);
        if (contains(hi)) queue.add(keys[rank(hi)]);
        return queue;
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i=1; i<size(); i++) {
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        }
        return true;
    }

    private boolean rankCheck() {
        for (int i=0; i<size(); i++) {
            if (i != rank(select(i))) return false;
        }
        for (int i=0; i<size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BinarySearchST<Character, Integer> st = new BinarySearchST<>();
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
        A 8
        C 4
        E 12
        H 5
        L 11
        M 9
        P 10
        R 3
        S 0
        X 7
 */
