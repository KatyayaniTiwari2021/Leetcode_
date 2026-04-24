class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0,0,-1, 1};

    class pair{

        int row;
        int col;

        pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] dis = new int[n][m];

        Queue< pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    dis[i][j] = 0;

                    q.offer(new pair(i, j));
                }else{
                    dis[i][j] = -1;
                }
            }
        }

//bfs

        while(!q.isEmpty()){
            pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            for(int i = 0; i < 4; i++){

                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < n && nr >= 0 && nc < m && nc >= 0 && dis[nr][nc] == -1){

                    dis[nr][nc] = dis[r][c] + 1;

                    q.offer(new pair(nr, nc));

                }

            }
        }
        return dis;
        
    }
}