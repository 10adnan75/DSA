/*  You are climbing a staircase. It takes n steps to reach the top.
 *  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?    
 *  
 *  Example - Input: n = 3
 *            Output: 3
 *            Explanation: There are three ways to climb to the top.
 *            1. 1 step + 1 step + 1 step
 *            2. 1 step + 2 steps
 *            3. 2 steps + 1 step
 *
 *  Constraints - 1 <= n <= 45
 */ 

import java.util.*;
import java.lang.*;
import java.io.*;

class ClimbingStairs {
    
    private int[] dp = new int[46];
    
    public int climbStairs(int n) {
        // Enhanced recursion - Runtime: 0 ms, Memory Usage: 37.7 MB
        /* if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int step = dp[n];
        if (step != 0) {
            return step;
        }
        step = climbStairs(n-1) + climbStairs(n-2);
        dp[n] = step;
        return step; */
        
        // Optimal memoization - Runtime: 0 ms, Memory Usage: 35.6 MB
        dp[0] = 1; dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public static void main (String[] args) throws java.lang.Exception {
        // client
    }
}
