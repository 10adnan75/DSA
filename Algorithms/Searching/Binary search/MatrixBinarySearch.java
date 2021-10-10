import java.util.Scanner;

public class MatrixBinarySearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int lo = 0, hi = rows*cols-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int value = matrix[mid/cols][mid%cols];
            if (value > target) {
                hi = mid - 1;
            } else if (value < target) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no. of rows: "); int rows = input.nextInt();
        System.out.print("Enter no. of columns: "); int cols = input.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.print("Enter keys: ");
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.print("Enter target: "); int target = input.nextInt();
        if (searchMatrix(matrix, target)) {
            System.out.println("Key is present!");
        } else {
            System.out.println("Key is not present!");
        }
    }
}

/*      OUTPUT:
        Enter no. of rows: 3
        Enter no. of columns: 3
        Enter keys: 1 2 3 4 5 6 7 8 9
        Enter target: 0
        Key is not present!
        Enter target: 1
        Key is present!
 */
