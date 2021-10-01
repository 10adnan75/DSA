/*  Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * 
 *  Example - Input: n = 4, k = 2
 *            Output:
 *            [
 *               [2,4],
 *               [3,4],
 *               [2,3],
 *               [1,2],
 *               [1,3],
 *               [1,4],
 *            ]
 *
 *  Constraints - 1 <= n <= 20
 *                1 <= k <= n
 */

import java.util.*;

class Combinations {
    
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    private void backTrack(int n, int k, int begin, Stack<Integer> stack) {
        if (stack.size() == k) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i=begin; i<=n-(k-stack.size())+1; i++) {
            stack.add(i);
            backTrack(n, k, i+1, stack);
            stack.pop();
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return ans;
        }
        backTrack(n, k, 1, new Stack<>());
        return ans;
    }
    
    public static void main (String[] args) {
        /* client */
    }
}
