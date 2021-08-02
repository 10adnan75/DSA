import java.util.*;
import java.lang.*;
import java.io.*;

public class ThreeSum {
    
    public static void threeSum(int[] a, int key) {
        for (int i=0; i<a.length-2; i++) {
            int j = i+1;
            int k = a.length-1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == key) System.out.println(a[i] + " + " + a[j] + " + " + a[k] + " = " + sum);
                if (sum >= key) {
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
        Arrays.sort(a);
        System.out.print("Solution:\n");
        for (int i=0; i<size; i++) threeSum(a, a[i]);
    }
}


/*      Enter size: 5
        Enter keys: 11 2 1 6 3
        Solution:
        1 + 2 + 3 = 6
        2 + 3 + 6 = 11
*/
