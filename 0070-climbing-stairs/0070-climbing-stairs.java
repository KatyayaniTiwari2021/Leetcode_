class Solution {
    public int climbStairs(int n) {

        Integer[] dp = new Integer[n + 1];

        return solve(n, 0, dp);
        
    }

    private int solve(int n, int count,Integer[] dp){
        if(count == n) return 1;
        if(count > n) return 0;

        if(dp[count]!= null){
            return dp[count];
        }

        int one = solve(n, count + 1, dp);
  
        int two = solve(n, count + 2, dp);
        

        return dp[count] = one + two;
    }
}