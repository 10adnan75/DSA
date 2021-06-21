import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxPriorityQueue {

    private static class myComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer x, Integer y) {
            int comp = x.compareTo(y);
            if (comp > 0) {
                return -1;
            } else if (comp < 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new myComparator());
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
