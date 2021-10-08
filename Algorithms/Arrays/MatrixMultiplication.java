import java.util.Scanner;

public class MatrixMultiplication {

    public static int[][] makeMatrix(int row, int column) {
        Scanner S = new Scanner(System.in);
        int[][] matrix = new int[row][column];
        System.out.print("Enter Matrix elements: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = S.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b, int row, int column) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < b.length; k++) {
                    matrix[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.print("Enter no. of rows of 1st matrix: ");
        int r1 = S.nextInt();
        System.out.print("Enter no. of columns of 1st matrix: ");
        int c1 = S.nextInt();
        int[][] a = makeMatrix(r1, c1);
        System.out.println("A: "); displayMatrix(a);
        System.out.print("Enter no. of rows of 2nd matrix: ");
        int r2 = S.nextInt();
        System.out.print("Enter no. of columns of 2nd matrix: ");
        int c2 = S.nextInt();
        if (c1 != r2) {
            System.out.println("Given matrices can't be multiplied!");
        } else {
            int[][] b = makeMatrix(r2, c2);
            System.out.println("B: "); displayMatrix(b);
            int[][] result = multiplyMatrix(a, b, r1, c2);
            System.out.println("Resultant Matrix:");
            displayMatrix(result);
        }
    }
}

/*      OUTPUT:
        Enter no. of rows of 1st matrix: 3
        Enter no. of columns of 1st matrix: 3
        Enter Matrix elements: 1 0 0 2 1 1 0 1 1
        A: 
          1 0 0
          2 1 1
          0 1 1
        Enter no. of rows of 2nd matrix: 3
        Enter no. of columns of 2nd matrix: 3
        Enter Matrix elements: 0 0 3 2 1 1 0 0 1
        B: 
          0 0 3
          2 1 1
          0 0 1
        Resultant Matrix:
          0 0 3
          2 1 8
          2 1 2
 */
