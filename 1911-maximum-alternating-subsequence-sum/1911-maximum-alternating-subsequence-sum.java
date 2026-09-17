class Solution {

    Long[][] dp;

    int n;

    public long maxAlternatingSum(int[] nums) {

        n = nums.length;

        dp = new Long[n][2];

        // for(long[] row : dp){
        //     Arrays.fill(row, Long.MIN_VALUE);
        // }

        return solve(nums, 0, 0);

        
    }

    public long solve(int[] nums, int i, int state){
        if(i == n){
            return 0;
        }

        if(dp[i][state] != null){
            return dp[i][state];
        }

        //skip
        long skip = solve(nums, i + 1, state);

        //take
        long take;

        if(state == 0){
            take = nums[i] + solve(nums, i + 1, 1);
        }else{
            take = -nums[i] + solve(nums, i + 1, 0);
        }

        dp[i][state] = Math.max(skip, take);

        return dp[i][state];
    }
}