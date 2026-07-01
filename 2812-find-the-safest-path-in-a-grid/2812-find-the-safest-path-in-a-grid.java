class Solution {

    static int[] dr = {-1,1,0,0};  //up down left right
    static int[] dc = {0,0, -1,1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int n = grid.size();

        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;

        int[][] distance = new int[n][n];

        for(int[] row : distance){
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    distance[i][j] = 0;

                    q.offer(new int[]{i,j});

                }
            }
        }

        while(!q.isEmpty()){

            int[] curr =  q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && distance[nr][nc] == -1){

                    distance[nr][nc] = 1 + distance[r][c];

                    q.offer(new int[]{nr, nc});

                }
            }
        }


        //finding maximum 

        int low = 0;
        int high = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                high = Math.max(high, distance[i][j]);
            }
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canReach(distance,mid)){
                ans = mid;
                low = mid + 1;

            }else{
                high = mid - 1;
            }
        }

        return ans;
        
    }

    private boolean canReach(int[][] grid, int mid){
        int n = grid.length;

        if(grid[0][0] < mid) return false;

        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()){

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            if(r == n-1 && c == n- 1){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int nr = dr[i] + r;
                int nc = dc[i] + c;

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc] && grid[nr][nc] >= mid){

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});

                }
            }

        }

        return false;
    }
}