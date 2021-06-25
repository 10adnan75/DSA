/***
 * Given a contiguous sequence of numbers in which each number repeats thrice, there is exactly one missing number. Find the missing number.
 * eg: i. 11122333 -> missing number is 2
 *     ii. 11122233344455666 -> missing number is 5
 ***/

import java.util.Scanner;

public class tripleBinarySearch {

    public static int findMissingNumber(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j - 1) {
            int mid = i + (j - i) / 2;
            int inI = mid, inJ = mid;
            while (inI >= 0 && a[inI] == a[mid]) inI--;
            while (inJ < a.length && a[inJ] == a[mid]) inJ++;
            if (inJ - inI == 3) return a[mid];
            if (inI > 0 && (inI + 1) % 3 != 0) {
                j = inI;
            } else {
                i = inJ;
            }
        }
        return a[i];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = input.nextInt();
        int[] myArray = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) myArray[i] = input.nextInt();
        System.out.print("Missing number is: " + findMissingNumber(myArray));
    }
}

/*
        OUTPUT:
        Enter size: 17
        Enter array elements: 1 1 1 2 2 2 3 3 3 4 4 4 5 5 6 6 6
        Missing number is: 5
 */
