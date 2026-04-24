class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    class pair{
        int row;
        int col;
        int diff;

        pair(int row, int col, int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int[] row: dist){
            Arrays.fill(row, (int)1e9);
        }


        PriorityQueue<pair> q = new PriorityQueue<>((a,b) -> a.diff - b.diff);

        q.offer(new pair(0,0,0));

        dist[0][0] = 0;

        while(!q.isEmpty()){
            pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.diff;

            if(r == n - 1 && c == m - 1) return d;

            if(d > dist[r][c]) continue;

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int newDiff = Math.max(d, Math.abs(heights[r][c] - heights[nr][nc]));

                    if(newDiff < dist[nr][nc]){
                        dist[nr][nc] = newDiff;
                        q.offer(new pair(nr, nc, newDiff));
                    }

                    
                }
            }


            

        }

        return 0;





        
    }
}