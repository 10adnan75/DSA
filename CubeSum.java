import java.util.Scanner;

public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter range: "); int n = input.nextInt();
        MinPQBinaryHeap<CubeSum> pq = new MinPQBinaryHeap<>(n+1);
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            System.out.println(s);
            if (s.j < n)
                pq.insert(new CubeSum(s.i, s.j + 1));
        }
    }
}
/*      OUTPUT:
        Enter range: 5
        0 = 0^3 + 0^3
        1 = 0^3 + 1^3
        2 = 1^3 + 1^3
        8 = 0^3 + 2^3
        9 = 1^3 + 2^3
        16 = 2^3 + 2^3
        27 = 0^3 + 3^3
        28 = 1^3 + 3^3
        35 = 2^3 + 3^3
        54 = 3^3 + 3^3
        64 = 0^3 + 4^3
        65 = 1^3 + 4^3
        72 = 2^3 + 4^3
        91 = 3^3 + 4^3
        125 = 0^3 + 5^3
        126 = 1^3 + 5^3
        128 = 4^3 + 4^3
        133 = 2^3 + 5^3
        152 = 3^3 + 5^3
        189 = 4^3 + 5^3
        250 = 5^3 + 5^3
 */
