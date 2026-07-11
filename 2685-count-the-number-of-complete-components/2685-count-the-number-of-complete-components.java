class Solution {

    static int edge;
    static int vertices;

    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int component = 0;

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){

            if(!vis[i]){

                vertices  = 0;
                edge = 0;

                dfs(i, adj, vis); 
                if(edge/2 == vertices*( vertices - 1)/2){
                    component++;
                }     
            }
        }

        return component;
        
    }
    

    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        vis[src] = true;

        vertices++;

        edge += adj.get(src).size();

        for(int neighbour : adj.get(src)){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis);
            }
        }
    }
}