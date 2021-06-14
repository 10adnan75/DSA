import java.util.Scanner;

public class KnuthShuffle {
    private KnuthShuffle() { }

    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            int r = (int) (Math.random() * (i+1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void shuffleAlternate(Object[] a) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner((System.in));
        System.out.print("Enter size: "); int size = input.nextInt();
        Object[] myArray = new Object[size];
        System.out.print("Enter array keys: "); for (int i=0; i<size; i++) myArray[i] = input.next();
        KnuthShuffle.shuffle(myArray);
        System.out.print("Shuffled keys: "); for (Object i : myArray) System.out.print(i + " ");
    }
}

/*      OUTPUT:
        Enter size: 5
        Enter array keys: adnan 1 2 3 4
        Shuffled keys: 1 3 adnan 2 4
 */
