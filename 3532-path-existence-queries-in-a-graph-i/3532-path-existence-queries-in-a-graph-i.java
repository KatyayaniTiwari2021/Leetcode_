class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int q = queries.length;

        int[] comp = new int[nums.length];

        int compID = 0;

        comp[0] = compID;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > maxDiff){
                compID++;
            }
            comp[i] = compID;
        }
        boolean[] res = new boolean[q];

        for(int i = 0; i < q; i++){

            res[i] = (comp[queries[i][0]] == comp[queries[i][1]]);

        }
        return res;
        
    }
}