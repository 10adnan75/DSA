public class InversionMergeSort {

    private static class MergeSort {

        public static int merge(int[] a, int[] aux, int lo, int mid, int hi) {
            int pairs = 0;
            for (int k=0; k<=hi; k++) aux[k] = a[k];
            int i = lo, j = mid+1;
            for (int k=lo; k<=hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (aux[j] < aux[i]) {
                    a[k] = aux[j++];
                    pairs += (mid + 1) - (lo + i);
                }
                else a[k] = aux[i++];
            }
            return pairs;
        }

        public static int sort(int[] a, int[] aux, int lo, int hi) {
            int count = 0;
            if (hi <= lo) return count;
            int mid = lo + (hi-lo)/2;
            count += sort(a, aux, lo, mid);
            count += sort(a, aux, mid+1, hi);
            count += merge(a, aux, lo, mid, hi);
            return count;
        }

        public static int sort(int[] a) {
            int[] aux = new int[a.length];
            return sort(a, aux, 0, a.length-1);
        }
    }

        public static int countInversionPairs(int[] a) {
            return new MergeSort().sort(a);
        }

        public static void main(String[] args) {
            int[] myArray = {4,5,6,1,2,3};
            System.out.println("Pairs: " + countInversionPairs(myArray));
        }
}
