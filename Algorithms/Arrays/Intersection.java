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
        
        System.out.println("A: ");
        for (int i=0; i<n; i++) {
            System.out.println(" " + A.get(i).getX() + " " + A.get(i).getY());
        }
        
        System.out.println("B: ");
        for (int i=0; i<n; i++) {
            System.out.println(" " + B.get(i).getX() + " " + B.get(i).getY());
        }
        
        System.out.println("A intersection B: " + count);
    }
}

/*      How many points?: 5
        Input values for Set A and Set B: 
        A.x1: 0
        A.y1: 1
        B.x1: 2
        B.y1: 3
        A.x2: 4
        A.y2: 5
        B.x2: 6
        B.y2: 7
        A.x3: 8
        A.y3: 9
        B.x3: 0
        B.y3: 1
        A.x4: 2
        A.y4: 3
        B.x4: 4
        B.y4: 5
        A.x5: 6
        A.y5: 7
        B.x5: 8
        B.y5: 9
        A: 
        0 1
        4 5
        8 9
        2 3
        6 7
        B: 
        2 3
        6 7
        0 1
        4 5
        8 -1
        A intersection B: 4
*/
