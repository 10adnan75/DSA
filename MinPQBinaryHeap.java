import java.util.Scanner;

public class MinPQBinaryHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MinPQBinaryHeap(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return min;
    }

    private void swim(int k) {
        while (k>1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j<N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
    }

    public void display() {
        for (int i=0; i<=N; i++) System.out.print(pq[i] + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: "); int size = input.nextInt();
        MinPQBinaryHeap<Integer> minPQ = new MinPQBinaryHeap<>(size);
        System.out.print("Enter elements: "); for (int i=0; i<size; i++) minPQ.insert(input.nextInt());
        minPQ.display();
        System.out.println();
        while (!minPQ.isEmpty()) System.out.print(minPQ.delMin() + " ");
    }
}

/*      OUTPUT:
        Enter size: 5
        Enter elements: 5 2 4 1 3
        null 1 2 4 5 3
        1 2 3 4 5
 */
