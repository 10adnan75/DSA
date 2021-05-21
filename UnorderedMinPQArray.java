import java.util.Scanner;

public class UnorderedMinPQArray<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N;

    public UnorderedMinPQArray(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMin() {
        if(isEmpty()) throw new NullPointerException();
        int min = 0;
        for (int i=1; i<N; i++) if (less(i, min)) min = i;
        exch(min, N-1);
        return pq[--N];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public void display() {
        if(isEmpty()) {
            System.out.print("Queue is empty!");
            return;
        }
        System.out.print("Priority Queue: ");
        for (int i=0; i<N; i++) System.out.print(pq[i] + " ");
    }

    // client
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = input.nextInt();
        UnorderedMinPQArray<Integer> minPQ = new UnorderedMinPQArray<>(size);
        System.out.print("Enter elements: ");
        for (int i=0; i<size; i++) minPQ.insert(input.nextInt());
        minPQ.display();
        System.out.println();
        for (int i=0; i<size; i++) System.out.print(minPQ.delMin() + " ");
        System.out.println();
        minPQ.display();
    }
}
