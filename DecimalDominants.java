import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DecimalDominants {

    public static ArrayList<Integer> getDecimalDominants (int[] a, int k) {

        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> decimalDominants = new ArrayList<>();


        for (int value : a) {
            if (myMap.containsKey(value)) {
                myMap.put(value, myMap.get(value) + 1);
            } else {
                myMap.put(value, 1);
            }
        }

        for (int key : myMap.keySet()) {
            if (myMap.get(key) > a.length / k) {
                decimalDominants.add(key);
            }
        }

        return decimalDominants;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = input.nextInt();
        int[] a = new int[size];
        System.out.println("Enter keys: ");
        for (int i=0; i<size; i++) a[i] = input.nextInt();
        System.out.print("Enter dominant: ");
        int dominant = input.nextInt();
        ArrayList<Integer> decimalDominants = getDecimalDominants(a, dominant);
        if (!decimalDominants.isEmpty()) {
            for (int decimalDominant : decimalDominants) System.out.print(decimalDominant + " ");
        } else {
            System.out.println("No keys occur more than N/" + dominant + " times!");
        }
    }
}
