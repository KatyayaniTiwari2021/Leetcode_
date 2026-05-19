class Solution {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        
        int components = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid, visited );
                    components++;
                }
            }
        }

        return components;
        
    }
    private void dfs(int i, int j, char[][] grid, boolean[][] visited){
        
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;

        if(visited[i][j] == true) return;

        visited[i][j] = true;

        for(int k = 0; k < 4; k++){
            dfs(i + dr[k], j + dc[k], grid, visited);
        }

        

        
        

        


    }
}