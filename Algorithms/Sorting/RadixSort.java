import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static int getMax(int[] a, int n) {
        int max = 0;
        for (int i=1; i<n; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    public static void countSort(int[] a, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        int i;
        for (i=0; i<n; i++) count[(a[i]/exp)%10]++;
        for (i=1; i<10; i++) count[i] += count[i-1];
        for (i=n-1; i>=0; i--) {
            output[count[(a[i]/exp)%10]-1] = a[i];
            count[(a[i]/exp)%10]--;
        }
        for(i=0; i<n; i++) a[i] = output[i];
    }

    public static void sort(int[] a) {
        int m = getMax(a, a.length);
        for (int exp=1; m/exp>0; exp*=10) countSort(a, a.length, exp);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = input.nextInt();
        int[] myArray = new int[size];
        System.out.print("Enter array elements: ");
        for (int i=0; i<size; i++) myArray[i] = input.nextInt();
        RadixSort.sort(myArray);
        System.out.print("Array after sort: ");
        for (int i=0; i<size; i++) System.out.print(myArray[i] + " ");
    }
}

/*      OUTPUT:
        Enter size of array: 5
        Enter array elements: 99999 999999 999 99999999 9999999
        Array after sort: 999 99999 999999 9999999 99999999
 */
