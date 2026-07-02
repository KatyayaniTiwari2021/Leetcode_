class Solution {

    int  n;

    public int findCircleNum(int[][] isConnected) {

        n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }



        boolean[] vis = new boolean[n];

        int components = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
        
                }
            }
        }
        for(int i = 0; i < n; i++){
           if(vis[i] == false){
            dfs(adj, vis, i);
            components++;

           }
        }
        return components;

        
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src){

        vis[src] = true;

        for(int adjNode : adj.get(src)){
            if(vis[adjNode] == false){
                dfs(adj, vis, adjNode);
            }
        }
    }
}