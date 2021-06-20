import java.util.Scanner;

public class TaxicabNumbers {
    private final int[] taxicabNumbers;

    public TaxicabNumbers(int range) {
        taxicabNumbers = new int[range + 1];
        storeTaxicabNumbers(range);
    }

    public void storeTaxicabNumbers(int N) {
        int i = 1, count = 0;
        while (count < N) {
            int c = 0;
            for (int j=1; j<=Math.pow(i, 1.0/3); j++) {
                for (int k=j+1; k<=Math.pow(i, 1.0/3); k++) {
                    if (j*j*j + k*k*k == i) {
                        c++;
                    }
                }
            }
            if (c == 2) {
                count++;
                taxicabNumbers[count] = i;
            }
            i++;
        }
    }

    public int getTaxicabNumber(int N) {
        return taxicabNumbers[N];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String res;
        System.out.print("Enter range: "); int range = input.nextInt();
        if (range == 1) res = "st";
        else if (range == 2) res = "nd";
        else if (range == 3) res = "rd";
        else res = "th";
        TaxicabNumbers tn = new TaxicabNumbers(range);
        System.out.println((range+res) + " Taxicab number: " + tn.getTaxicabNumber(range));
    }
}

/*      OUTPUT:
        Enter range: 7
        7th Taxicab number: 40033
 */
