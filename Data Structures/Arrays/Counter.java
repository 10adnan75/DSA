import java.util.Random;
import java.util.Scanner;

public class Counter implements Comparable<Counter> {
    private final String name;
    private int count = 0;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return name + ": " + count + ". ";
    }

    @Override
    public int compareTo(Counter that) {
        if (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else return 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("How many counters?: "); int N = input.nextInt();
        System.out.print("Enter trials: "); int trials = input.nextInt();
        Counter[] hits = new Counter[N];
        for (int i=0; i<N; i++) hits[i] = new Counter("counter" + i);
        for (int t=0; t<trials; t++) hits[random.nextInt(N)].increment();
        System.out.print("Results -> "); for (int i=0; i<N; i++) System.out.print(hits[i]);
    }
}
/*      OUTPUT:
        How many counters?: 5
        Enter trials: 10
        Results -> counter0: 3. counter1: 2. counter2: 4. counter3: 0. counter4: 1.
 */
