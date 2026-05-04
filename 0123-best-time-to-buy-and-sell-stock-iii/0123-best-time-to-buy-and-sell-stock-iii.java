class Solution {

    // buy : k = 0
    //sell : k = 1

    //int max = 0;

    Integer[][][] dp;

    public int maxProfit(int[] prices) {

        int n = prices.length;
        
        dp = new Integer[n + 1][3][5];
        return solve(0, 0, 4, prices);
        
    }

    private int solve(int i, int k, int x, int[] prices){

        if(i == prices.length) return 0;

        if(dp[i][k][x] != null){
            return dp[i][k][x];
        }
        
        int profit = 0;

        if(x > 0 && k == 0){

            int buy = -prices[i] + solve(i + 1, 1, x - 1, prices);
            int skip = solve(i + 1, 0, x, prices);

            profit = Math.max(buy, skip);

        }

        if(x > 0 && k == 1){

            int sell = prices[i] + solve(i + 1, 0, x - 1, prices);
            int skip = solve(i + 1, 1, x, prices);

            profit = Math.max(sell, skip);


        }

        return dp[i][k][x] = profit;

    }
}