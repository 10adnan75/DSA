import java.util.*;
import java.lang.*;
import java.io.*;

public class SearchBitonicArray {
    
    public static int ascendingBinarySearch(int[] a, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    public static int descendingBinarySearch(int[] a, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] < key) {
                hi = mid - 1;
            } else if (a[mid] > key) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    public static int searchBitonic(int[] a, int n, int key, int index) {
        if (key > a[index]) {
            return -1;
        } else if (key == a[index]) {
            return index;
        } else {
            int temp = ascendingBinarySearch(a, 0, index-1, key);
            if (temp != -1) {
                return temp;
            }
            return descendingBinarySearch(a, index+1, n-1, key);
        }
    }
    
    public static int findBitonicPoint(int[] a, int n, int l, int r) {
        int mid = (r + l) / 2;
        int bitonicPoint = 0;
        if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
            return mid;
        } else {
            if (a[mid] > a[mid-1] && a[mid] < a[mid+1]) {
                bitonicPoint = findBitonicPoint(a, n, mid, r);
            } else {
                if (a[mid] < a[mid-1] && a[mid] > a[mid+1]) {
                    bitonicPoint = findBitonicPoint(a, n, l, mid);
                }
            }
        }
        return bitonicPoint;
    }
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size: "); int size = input.nextInt();
        int[] a = new int[size]; 
        System.out.println("Enter keys: "); for (int i=0; i<size; i++) a[i] = input.nextInt();
        System.out.println("Enter key to search: ");
        int key = input.nextInt();
        int n = a.length, l = 0, r = n-1;
        int index = findBitonicPoint(a, n, l, r);
        int x = searchBitonic(a, n, key, index);
        System.out.println(x == -1 ? "Key not found!" : "Key present at index " + x); 
    }
}

/*      OUTPUT:
        Enter size: 8
        Enter keys: 8 1 2 3 4 5 -2 -3
        Enter key to search: -2
        Key present at index 6
*/
