import java.util.*;

public class TwoSum {
    
    private static boolean sum(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int value = a[key];
        while (left < right) {
            if (left == key || a[left] + a[right] < value) {
                left++;
            } else if (right == key || a[left] + a[right] > value) {
                right--;
            } else {
                System.out.println(a[left] + "  " + a[right] + "  " + value);
                return true;
            }
        }
        return false;
    }

    public static boolean threesum(int[] a) {
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            if (sum(a, i)) return true;
        }
        return false;
    }
    
    public static void main (String[] args) {
        int[] a = {0, 2, 3, 5};
        System.out.println(threesum(a));
    }
}

/*      OUTPUT:
        -2 + 1 = -1
        true
*/
