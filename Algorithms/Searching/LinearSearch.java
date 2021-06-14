import java.util.Scanner;

public class LinearSearch {

    public static int search (int[] a, int key) {
        for (int i = 0; i < a.length ; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] myArray = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) myArray[i] = input.nextInt();
        System.out.print("Enter element to find: ");
        int x = input.nextInt();
        int pos = search(myArray, x);
        if (pos == -1) System.out.println(x + " is not present in the array.");
        else System.out.println(x + " is present at position " + pos);
    }
}
