import java.util.*;
import java.lang.*;
import java.io.*;

class AnagramSubstringSearch {
    
    private static List<Integer> findIndices(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        List<Integer> indices = new ArrayList<>();
        int[] textCount = new int[256];
        int[] patternCount = new int[256];
        for (int i=0; i<m; i++) {
            textCount[text.charAt(i)]++;
            patternCount[pattern.charAt(i)]++;
        }
        for (int i=m; i<n; i++) {
            if (isCountEqual(textCount, patternCount)) {
                indices.add(i-m);
            }
            textCount[text.charAt(i-m)]--;
            textCount[text.charAt(i)]++;
        }
        if (isCountEqual(textCount, patternCount)) {
            indices.add(n-m);
        }
        return indices;
    }
    
    private static boolean isCountEqual(int[] textCount, int[] patternCount) {
        for (int i=0; i<256; i++) {
            if (textCount[i] != patternCount[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: "); String text = input.next();
        System.out.print("Enter pattern: "); String pattern = input.next();
        System.out.print("Anagrams found at: " + findIndices(text, pattern));
    }
}

/*      OUTPUT:
        Enter text: XYYZXZYZXXYZ
        Enter pattern: XYZ
        Anagrams found at: [2, 4, 6, 9]
*/        
