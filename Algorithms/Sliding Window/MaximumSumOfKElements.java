import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSumOfKElements {
	
	public static int findMaxSum(int[] a, int k) {
	    int maxSum = 0, currSum = 0;
	    for (int i=0; i<k; i++) {
	        currSum += a[i];
	    }
	    maxSum = currSum;
	    for (int i=k; i<a.length; i++) {
	        currSum -= a[i-k];
	        currSum += a[i];
	        if (maxSum < currSum) {
	            maxSum = currSum;
	        }
	    }
	    return maxSum;
	}
	
	public static void main (String[] args) throws java.lang.Exception { // client
		Scanner input = new Scanner(System.in);
		System.out.print("Enter array length: "); int n = input.nextInt();
		int[] a = new int[n];
		System.out.print("Enter keys: "); for (int i=0; i<n; i++) a[i] = input.nextInt();
		System.out.print("Enter no. of k elements: "); int k = input.nextInt();
		System.out.print("Maximum sum of " + k + " consecutive elements is: " + findMaxSum(a, k));
	}
}

/*      OUTPUT:
        Enter array length: 9
        Enter keys: 1 4 2 10 2 3 1 0 20
        Enter no. of k elements: 4
        Maximum sum of 4 consecutive elements is: 24
*/
