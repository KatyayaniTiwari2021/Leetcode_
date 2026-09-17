class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int[] ans = new int[nums.length];

        int[] prefix = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            prefix[i] = left;
            left = left * nums[i];
        }

        int right = 1;
        int[] suffix = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            suffix[i] = right;
            right = right * nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            ans[i] = prefix[i] * suffix[i];

        }
        return ans;
        
    }
}