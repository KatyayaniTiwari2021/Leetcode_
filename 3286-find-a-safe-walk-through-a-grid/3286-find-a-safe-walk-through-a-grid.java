class Solution {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dis = new int[m][n];

        for(int[] row : dis){

            Arrays.fill(row, -1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>( (a, b) -> a[0] - b[0]);

        q.add(new int[]{grid.get(0).get(0), 0,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(dis[r][c] >= 0) continue;

            dis[r][c] = cost;

            for(int i = 0; i < 4; i++){

                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && dis[nr][nc] < 0 ){

                    q.offer(new int[]{cost + grid.get(nr).get(nc), nr, nc});

                }
            }
        }
        return dis[m-1][n-1] < health;

        
        
    }
}