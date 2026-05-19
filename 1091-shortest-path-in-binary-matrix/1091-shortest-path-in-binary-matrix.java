class Solution {

    static class pair{
        int row;
        int col;
        int dir;

        pair(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    //up, down, left, right, dul, dur, ddl, ddr
    static int[] dr = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        Queue<pair> q = new LinkedList<>();

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        q.offer(new pair(0, 0, 1));

        visited[0][0] = true;
        
       

        while(!q.isEmpty()){
            pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;
            int d = curr.dir;

            if(r == n - 1 && c == n - 1) return d;

            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < n && nc < n && nr >= 0 && nc >= 0 && grid[nr][nc] == 0 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new pair(nr, nc, d + 1));
                }
            }


        }

        return -1;

        
    }
}