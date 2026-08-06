class Solution {
    Integer[][] dp;
    int m;
    int n; 
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Integer[m + 1][n + 1];

        return solve(0, 0, grid);
        
    }
    public int solve(int i, int j, int[][] grid){
        if(i >= m || j >= n ) return (int)1e9;

        if( i == m-1 && j == n-1) return grid[m - 1][n - 1];
 

        if(dp[i][j] != null) return dp[i][j];

        int right =  solve(i, j + 1, grid);
        int down =  solve(i + 1, j, grid);

        return dp[i][j] =  grid[i][j] + Math.min(right, down);
    }
}