class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        if(source == destination) return true;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());

        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(v).add(u);
            adj.get(u).add(v);
        }
       
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        
        while(!q.isEmpty()){
           int node =  q.poll();
           for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                vis[adjNode] = 1;
                q.offer(adjNode);
            }

           }

        }
        return vis[destination] == 1;

        // boolean[] vis = new boolean[n];
        // dfs(source, vis, adj);
        // if(vis[destination] == true) return true;

        // return false;

        
    }

    // public void dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
    //     vis[src] = true;
    //     for(int adjNode : adj.get(src)){
    //         if(vis[adjNode] == false){
               
    //             dfs(adjNode, vis, adj);
                
    //         }
    //     }
    // }
}