class Solution {

    static int[][] dir = {
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2} };

        
    Double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {

        dp = new Double[n + 1][n + 1][k+1];       
        return solve(n, row, column, k);
        
    }

    public double solve(int n, int r, int c, int moves){
        if(moves == 0){
            return 1.0;
        }

        if(dp[r][c][moves] != null) return dp[r][c][moves];

        double ans = 0.0;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < n && nr >= 0 && nc < n && nc >= 0){
                ans += solve(n, nr, nc, moves-1)/8.0;
            }
        }
        return dp[r][c][moves] = ans;

    }
}