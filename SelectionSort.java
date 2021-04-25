import java.util.Scanner;

public class SelectionSort {

    public static void swap (int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void sort (int[] a) {
        for (int i=0; i<a.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<a.length; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            swap(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = input.nextInt();
        int[] myArray = new int[size];
        System.out.println("Enter array elements: ");
        for (int i=0; i<size; i++) myArray[i] = input.nextInt();
        sort(myArray);
        System.out.print("Array after sort: ");
        for (int i=0; i<size; i++) System.out.print(myArray[i] + " ");
    }
}
