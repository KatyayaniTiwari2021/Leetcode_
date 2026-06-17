class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length + 1];
        return solve(nums, 0, dp);
        
    }
    private int solve(int[]  nums, int i, Integer[] dp){
        if(i >= nums.length) return 0;

        if(dp[i]!= null){
            return dp[i];
        }

        int rob = nums[i] + solve(nums, i + 2, dp);
        int skip = solve(nums, i + 1, dp);

        return dp[i]  = Math.max(rob, skip);
    }
}