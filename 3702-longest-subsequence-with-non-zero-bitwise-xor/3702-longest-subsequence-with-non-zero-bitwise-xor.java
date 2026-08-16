class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean zeroes = true;
        for(int i=0;i<nums.length;i++){
            xor = xor^nums[i];
            if(nums[i]!=0){
                 zeroes = false;
            }
        }
        if(xor !=0){
            return nums.length;
        }else{
             if(zeroes){
                 return 0;
             }
        }
        return nums.length-1;
        
    }
}