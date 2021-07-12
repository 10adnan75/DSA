import java.util.Stack;

public class TowerOfHanoi {
    private static final int TOWERS = 3;

    private static class Tower {
        private final Stack<Integer> disks;
        private final int index;

        public Tower(int i) {
            disks = new Stack<>();
            index = i;
        }

        @Deprecated
        public int getIndex() {
            return index;
        }

        public void add(int disk) {
            if (!disks.isEmpty() && disks.peek() <= disk) {
                System.err.println("Error placing disk " + disk);
            } else {
                disks.push(disk);
            }
        }

        public void moveTopTo(Tower tower) {
            int top = disks.pop();
            tower.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n <= 0) return;
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            System.out.println("Moved top from " + this.index + " to " + destination.index);
            buffer.moveDisks(n-1, destination, this);
        }

        public String toString() {
            return disks.toString();
        }
    }

    public Tower printHanoiTower(int numRings) {
        Tower[] towers = new Tower[TOWERS];
        for (int i=0; i<towers.length; i++) {
            towers[i] = new Tower(i);
        }
        for (int i=numRings; i>=1; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(numRings, towers[2], towers[1]);
        return towers[2];
    }

    public static void main(String[] args) {
        TowerOfHanoi solution = new TowerOfHanoi();
        Tower tower = solution.printHanoiTower(5);
        System.out.println("Tower: " + tower.toString());
        assert tower.toString().equals("[5, 4, 3, 2, 1]");
    }
}

/*      OUTPUT:
        Moved top from 0 to 2
        Moved top from 0 to 1
        Moved top from 2 to 1
        Moved top from 0 to 2
        Moved top from 1 to 0
        Moved top from 1 to 2
        Moved top from 0 to 2
        Moved top from 0 to 1
        Moved top from 2 to 1
        Moved top from 2 to 0
        Moved top from 1 to 0
        Moved top from 2 to 1
        Moved top from 0 to 2
        Moved top from 0 to 1
        Moved top from 2 to 1
        Moved top from 0 to 2
        Moved top from 1 to 0
        Moved top from 1 to 2
        Moved top from 0 to 2
        Moved top from 1 to 0
        Moved top from 2 to 1
        Moved top from 2 to 0
        Moved top from 1 to 0
        Moved top from 1 to 2
        Moved top from 0 to 2
        Moved top from 0 to 1
        Moved top from 2 to 1
        Moved top from 0 to 2
        Moved top from 1 to 0
        Moved top from 1 to 2
        Moved top from 0 to 2
        Tower: [5, 4, 3, 2, 1]
 */
