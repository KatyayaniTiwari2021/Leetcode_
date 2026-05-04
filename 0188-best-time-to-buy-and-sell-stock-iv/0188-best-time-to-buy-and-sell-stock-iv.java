class Solution {
    Integer[][][] dp;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp =  new Integer[n + 1][2*k + 1][3]; 

        return solve(0, 2*k, 0, prices);
        
    }

    private int solve(int i, int k, int x, int[] prices){
        if(i == prices.length) return 0;

        if(dp[i][k][x] != null){
            return dp[i][k][x];
        }

        int maxProfit = 0;

        if(k > 0 && x == 0){
            int buy = -prices[i] + solve(i + 1, k - 1, 1, prices);
            int skip = solve(i + 1, k, 0, prices);

            maxProfit = Math.max(buy, skip);
        }

        if(k > 0 && x == 1){
            int sell = prices[i] + solve(i + 1, k - 1, 0, prices);
            int skip = solve(i + 1, k, 1, prices);
            
            maxProfit = Math.max(sell, skip);
        }

        return dp[i][k][x] = maxProfit;
    }
}