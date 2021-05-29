import java.util.Scanner;

public class MaxPQBinaryHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQBinaryHeap(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void swim(int k) {
        while (k>1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j<N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
    }

    public static void main(String[] args) { //client
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: "); int size = input.nextInt();
        MaxPQBinaryHeap<Integer> maxPQ = new MaxPQBinaryHeap<>(size);
        System.out.print("Enter elements: "); for (int i=0; i<size; i++) maxPQ.insert(input.nextInt());
        while (!maxPQ.isEmpty()) System.out.print(maxPQ.delMax() + " ");
    }
}
