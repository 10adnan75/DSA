import java.util.Scanner;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k=N/2; k>=1; k--) sink(a, k, N);
        while (N > 1) {
            exch(a, 1, N);
            sink(a, 1, --N);
        }
    }

    public static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j<N && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i-1]; a[i-1] = a[j-1]; a[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (Comparable comparable : a) System.out.print(comparable + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = input.nextInt();
        Comparable[] myArray = new Comparable[size];
        System.out.print("Enter array elements: ");
        for (int i=0; i<size; i++) myArray[i] = input.next();
        HeapSort.sort(myArray);
        System.out.print("Sorted array: ");
        show(myArray);
    }
}
/*  OUTPUT:
    Enter size of array: 5
    Enter array elements: a d n a n
    Sorted array: a a d n n
 */
