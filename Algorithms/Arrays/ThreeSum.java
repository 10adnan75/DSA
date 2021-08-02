import java.util.*;
import java.lang.*;
import java.io.*;

public class ThreeSum {
    
    public static void threeSum(int[] a) {
        Arrays.sort(a);
        for (int i=0; i<a.length-2; i++) {
            int j = i+1;
            int k = a.length-1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == 0) System.out.println(a[i] + " + " + a[j] + " + " + a[k] + " = " + sum);
                if (sum >= 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: "); int size = input.nextInt();
        int[] a = new int[size];
        System.out.print("Enter keys: "); for (int i=0; i<size; i++) a[i] = input.nextInt();
        System.out.print("Solution:\n");
        threeSum(a);
    }
}

/*      OUTPUT:
        Enter size: 5
        Enter keys: 1 2 -1 0 -2
        Solution:
        -2 + 0 + 2 = 0
        -1 + 0 + 1 = 0
*/
