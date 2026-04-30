class Solution {
    public int maxPathScore(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        Integer dp[][][] = new Integer[m][n][k + 1];

        int ans =  solve(0, 0, k, grid, dp);

        return (ans == -(int)1e9) ? -1 : ans; 

        
    }
    public int solve(int i, int j, int k, int[][] grid, Integer[][][] dp){

        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n || k < 0){
            return -(int)1e9;
        }
        //if(k < 0) return -(int)1e9;

        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        int cost = (grid[i][j] == 0)? 0 : 1;
        int score = grid[i][j];

        if( i == m - 1 && j == n - 1){
            if(k - cost < 0) return -(int)1e9;
            return score;
            
        }

        int down = solve(i + 1, j, k - cost, grid, dp);
        int right = solve(i, j + 1, k - cost, grid, dp);
        
        int ans = Math.max(down, right);
    
        return dp[i][j][k] = (ans == -(int)1e9 )? -(int)1e9 : score + ans;
    }

}