class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = 0;

        for(int stone : stones){
            sum+= stone;
        }

        int target = sum/2;

        Boolean[][] dp = new Boolean[n][target + 1];

        for(int i = 0; i <= target; i++){
            solve(n - 1, i, stones, dp);
        }

        int sum1 = 0;

        for(int i = target; i >= 0; i--){
            if(dp[n - 1][i] != null && dp[n -1][i]){
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;

        return Math.abs(sum2 - sum1);

        
    }

    public boolean solve(int idx, int target, int[]stones, Boolean[][] dp){
        if(target == 0){
            return true;
        }

        if(idx == 0){
            return stones[0] == target;
        }

        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        boolean  nontake = solve(idx - 1, target, stones, dp);

        boolean take = false;
        if(stones[idx] <= target){
            take = solve(idx - 1, target - stones[idx], stones, dp);
        }

        return dp[idx][target] = take || nontake;
    }
}