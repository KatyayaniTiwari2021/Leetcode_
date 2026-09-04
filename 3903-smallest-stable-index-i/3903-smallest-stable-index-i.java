class Solution {
    public int firstStableIndex(int[] nums, int k) {
    
        for(int i = 0; i < nums.length; i++){
            int max = -(int)1e9;
            int min = (int)1e9;
            for(int j = 0; j <= i; j++){
                max = Math.max(max, nums[j]);
            }

            for(int t = i; t < nums.length; t++){
                min = Math.min(min, nums[t]);
            }

            int instability = (max - min);

            if(instability <= k){
                return i;
            }
            
        }
        return -1;
        
        
    }
}