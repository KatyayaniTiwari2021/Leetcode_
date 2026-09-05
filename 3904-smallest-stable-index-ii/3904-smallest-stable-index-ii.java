class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        int[] prefMax = new int[n];

        prefMax[0] = nums[0];

        int[] prefMin = new int[n];

        prefMin[n - 1] = nums[n - 1];

        for(int i = 1; i < n ; i++){
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }

        for(int i = n - 2; i >= 0; i--){
            prefMin[i] = Math.min(prefMin[i + 1], nums[i]);
        }

        for(int i = 0; i < n; i++){
            int instability = prefMax[i] - prefMin[i];
            if(instability <= k){
                return i;
            }
        }

        return -1;
        
        
    }
}