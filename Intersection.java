import java.util.ArrayList;
import java.util.Scanner;

public class Intersection {

    private static class Point2D {
        private int x;
        private int y;
        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Point2D> A = new ArrayList<>();
        ArrayList<Point2D> B = new ArrayList<>();

        System.out.print("How many points?: ");
        int n = input.nextInt();
        System.out.println("Input values for Set A and Set B: ");
        for (int id=1; id<n+1; id++) {
            System.out.print("A.x" + id + ": ");
            int ax = input.nextInt();
            System.out.print("A.y" + id + ": ");
            int ay = input.nextInt();
            A.add(new Point2D(ax, ay));
            System.out.print("B.x" + id + ": ");
            int bx = input.nextInt();
            System.out.print("B.y" + id + ": ");
            int by = input.nextInt();
            B.add(new Point2D(bx, by));
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (A.get(i).getX()==B.get(j).getX() && A.get(i).getY()==B.get(j).getY()) count++;
            }
        }
        System.out.println("A intersection B: " + count);
    }
}
