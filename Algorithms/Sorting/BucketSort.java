import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class BucketSort {
    private static void sort(float[] a, int N) {
        if (N <= 0) {
            return;
        }
        Vector<Float>[] buckets = new Vector[N];
        for (int i=0; i<N; i++) buckets[i] = new Vector<>();
        for (int i=0; i<N; i++) {
            float index = a[i] * N;
            buckets[(int) index].add(a[i]);
        }
        for (int i=0; i<N; i++) {
            Collections.sort(buckets[i]);
        }
        int idx = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<buckets[i].size(); j++) {
                a[idx++] = buckets[i].get(j);
            }
        }
    }

    private static void sort(float[] a) {
        sort(a, a.length);
    }

    private static void show(float[] a) {
        for (float i : a) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = input.nextInt();
        float[] myArray = new float[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) myArray[i] = input.nextFloat();
        BucketSort.sort(myArray);
        System.out.print("Sorted array: ");
        show(myArray);
    }
}

/*      OUTPUT:
        Enter size: 5
        Enter array elements: 0.345 0.123 0.3453 0.123 0.786
        Sorted array: 0.123 0.123 0.345 0.3453 0.786
 */
