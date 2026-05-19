class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;


        dp = new Integer[n][n + 1];

        return solve(-1, 0, nums);
        
    }
    public int solve(int prev, int curr, int[] nums){

        int n = nums.length;

        if(curr == n) return 0;

        if(dp[curr][prev + 1] != null){
            return dp[curr][prev + 1];
        }

        int nontake = solve(prev, curr + 1, nums);

        int take = -(int)1e9;

        if(prev == -1 || nums[curr] > nums[prev]){

            take = 1 + solve(curr, curr + 1, nums);
        } 

        return dp[curr][prev+1] = Math.max(take, nontake);
    }
}