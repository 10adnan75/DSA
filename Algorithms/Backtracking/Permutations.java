/*  Given an array nums of distinct integers, return all the possible permutations. 
 *  You can return the answer in any order.
 *  
 *  Example - Input: nums = [1,2,3]
 *            Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *  Constraints - 1 <= nums.length <= 6
 *                -10 <= nums[i] <= 10
 *                All the integers of nums are unique.
 */

import java.util.*;

class Permutations {
    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int temp = 0;
    
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, 0, nums.length-1);
        return ans;
    }
    
    private void backTrack(int[] nums, int lo, int hi) {
        // Backtracking: O(n!)
        if (lo == hi) {
            List<Integer> l = new ArrayList<>();
            for (int i : nums) {
                l.add(i);
            }
            ans.add(l);
            return;
        }
        for (int i=lo; i<=hi; i++) {
            swap(nums, i, lo);
            backTrack(nums, lo+1, hi);
            swap(nums, i, lo);
        }
    }
    
    private void swap(int[] a, int x, int y) {
        if (x == y) {
            return;
        }
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    
    public static void main (String[] args) {
        // client
    }
}
