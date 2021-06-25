import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int search(int[] a, int lo, int hi, int key) {
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]) return mid;
            if (key < a[mid]) return search(a, 0, mid, key);
            return search(a, mid + 1, hi, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] myArray = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) myArray[i] = input.nextInt();
        Arrays.sort(myArray);
        System.out.print("Enter element to find: ");
        int x = input.nextInt();
        int pos = search(myArray, 0, myArray.length - 1, x);
        if (pos == -1) System.out.println(x + " is not present in the array.");
        else System.out.println(x + " is present at position " + pos);
    }
}
