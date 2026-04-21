class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length + 1][2];
        return solve(0,0, prices);
        
    }
    public int solve(int i, int k, int[] prices){
        if(i == prices.length){
            return 0;
        }

        int profit = 0;

        if(dp[i][k] != null){
            return dp[i][k];
        }

        if(k == 0){

            int pick = -prices[i] + solve(i+1, 1 , prices);
            int skip = solve(i+1, 0, prices);

            profit = Math.max(pick, skip);

        }
        if(k == 1){

            int pick =  prices[i] + solve(i+1, 0, prices);
            int skip = solve(i+1, 1, prices);

            profit = Math.max(pick, skip);
        }
        return dp[i][k] = profit;
    }
}