class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        
        dis[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] temp = new int[n];

            for(int j = 0; j < n; j++){
                temp[j] = dis[j];
            }

            for(int j = 0; j < flights.length; j++){

                int u = flights[j][0];
                int v = flights[j][1];
                int cost = flights[j][2];

                if(dis[u] != (int)1e9 && dis[u] + cost < temp[v]) {
                    temp[v] = dis[u] + cost;

                }

            }
            dis = temp;
        }

        return dis[dst] == (int)1e9 ? -1 : dis[dst];

        
        
    }
}