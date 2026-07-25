class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> set = new HashSet<>(); //bank

        for(String s : bank){
            set.add(s);
        }

        HashSet<String> vis = new HashSet<>(); //bank

        Queue<String> q = new LinkedList<>();

        int level = 0;

        q.offer(startGene);

        while(!q.isEmpty()){

            int len = q.size();

            for(int i = 0; i < len; i++){
                String curr = q.poll();

                if(curr.equals(endGene)){
                    return level;  //level
                }

                String str = "ACGT";

                for(char ch : str.toCharArray()){
                    
                    for(int j = 0; j < curr.length(); j++){
                        char[] arr = curr.toCharArray(); 
                        arr[j] = ch; //first A, then C, G, T

                        String neigh = new String(arr);

                        if(!vis.contains(neigh) && set.contains(neigh)){
                            vis.add(neigh);
                            q.offer(neigh);

                        }

                    }
                }
            }

            level++;

        }
        

        return -1;




        
    }
}