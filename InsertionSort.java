import java.util.Scanner;

public class InsertionSort {

    public static void sort (int[] a) {
        for (int i=1; i<a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
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
