class Solution {

    Integer[][] dp;
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new Integer[m + 1][n + 1];
        return solve(0,0, obstacleGrid);

    }

    private int solve(int i, int j, int[][] grid){
        if(i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == 1) return 0;

        if( i == m - 1 && j == n - 1) return 1;

        if(dp[i][j] != null){
            return dp[i][j];
        }


        int right = solve(i, j + 1,grid);
        int down = solve(i + 1, j, grid);

        return dp[i][j] = right + down;
    }
}