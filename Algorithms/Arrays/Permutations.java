import java.util.Arrays;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] a = new int[n], b = new int[n];
        System.out.println("Enter 1st array elements: ");
        for (int i=0; i<n; i++) a[i] = input.nextInt();
        System.out.println("Enter 2nd array elements: ");
        for (int i=0; i<n; i++) b[i] = input.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i=0; i<n; i++) {
            if (a[i]!=b[i]) {
                System.out.println("No");
                System.exit(0);
            }
        }
        System.out.println("Yes");
    }
}

/*      OUTPUT:
        Enter size: 5
        Enter 1st array elements: 1 2 3 4 5
        Enter 2nd array elements: 5 3 2 1 4
        Yes
*/
