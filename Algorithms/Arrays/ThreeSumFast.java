import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumFast {
    private ThreeSumFast() { }

    private static boolean containsDuplicate(int[] a) {
        for (int i=1; i<a.length; i++) {
            if (a[i] == a[i-1]) return true;
        }
        return false;
    }

    public static void printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicate(a)) throw new IllegalArgumentException("Array contains duplicate integers!");
        for (int i=0; i<n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) System.out.print(a[i] + " " + a[j] + " " + a[k] + ". ");
            }
        }
    }

    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicate(a)) throw new IllegalArgumentException("Array contains duplicate integers!");
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: "); int size = input.nextInt();
        int[] myArray = new int[size];
        System.out.print("Enter keys: "); for (int i=0; i<size; i++) myArray[i] = input.nextInt();
        int count = count(myArray);
        System.out.println("Count: " + count);
        System.out.print("Pairs: "); printAll(myArray);
    }
}
/*      OUTPUT:
        Enter size: 5
        Enter keys: 0 1 2 -1 -3
        Count: 2
        Pairs: -3 1 2. -1 0 1.
 */
