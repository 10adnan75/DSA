import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < a[lo])
                if (i == hi) break;
            while (a[lo] < a[--j])
                if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public static void sort(int[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int randomIndexToSwap = rand.nextInt(a.length);
            int temp = a[randomIndexToSwap];
            a[randomIndexToSwap] = a[i];
            a[i] = temp;
        }
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] myArray = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) myArray[i] = input.nextInt();
        sort(myArray);
        System.out.println("Sorted array: ");
        for (int i : myArray) System.out.print(i + " ");
    }
}
