import java.util.Scanner;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i=h; i<N; i++)
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            assert isHsorted(a, h);
                h /= 3;
        }
        assert isSorted(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i=h; i<a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
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
        for (int i=0; i<size; i++) myArray[i] = input.nextInt();
        ShellSort.sort(myArray);
        System.out.print("Sorted array: ");
        show(myArray);
    }
}
