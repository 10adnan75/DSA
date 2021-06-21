import java.util.PriorityQueue;
import java.util.Scanner;

public class MinPriorityQueue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (T-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            if (a == 1) {
                pq.offer(b);
            } else if (a == 2) {
                if (pq.size() == 0) System.out.println("-1");
                else System.out.println(pq.peek());
            } else {
                if (pq.size() == 0) continue;
                pq.poll();
            }
        }
    }
}
