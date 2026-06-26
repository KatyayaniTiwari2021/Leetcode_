class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        
        int res = 0;
        
        for(int i = 0; i < nums.length; i++){
            int cnt = 0;

            for(int j = i; j < nums.length; j++){
                
                int len = j - i + 1;

                if(nums[j] == target) cnt++;

                if(2 * cnt >  len){
                    res++;
                }



            }
        }
        return res;
        
    }
}