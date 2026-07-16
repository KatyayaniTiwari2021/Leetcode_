class Solution {

    boolean[] vis;
    public int findCircleNum(int[][] grid) {

        int n = grid.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1){

                    adj.get(i).add(j);
                    

                }
            }
        }

        int components = 0;

        vis = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, adj, grid);
                components++;
            }
        }

        return components;

        
    }

    private void dfs(int src, ArrayList<ArrayList<Integer>> adj, int[][] grid){

        vis[src] = true;

        for(int neigh : adj.get(src)){
            if(!vis[neigh]){
                dfs(neigh, adj, grid);
                vis[neigh] = true;
            }
        }
    }
}