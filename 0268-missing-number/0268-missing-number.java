class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        int missing = 0;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(nums[n - 1] != n){
                missing = n;
            }
            if( i + 1 != n  && nums[i + 1]  - nums[i] > 1){
                missing = nums[i + 1] - 1;
                
            }
        }
        return missing;
        
    }
}