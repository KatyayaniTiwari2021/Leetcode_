class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int components = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, grid, vis);
                    components++;
                }
            }

        }
        return components;
        
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis){

        int n = grid.length;
        int m = grid[0].length;

        //boundary condition

        if(i >= n || j >= m || i < 0 || j < 0 || vis[i][j] || grid[i][j] == '0'){
            return;
        }

        vis[i][j] = true;


        for(int idx = 0; idx < 4; idx++){

            int nr = i + dr[idx];
            int nc = j + dc[idx];
             
            dfs(nr, nc, grid, vis);
                
            
        }

    }

}