class Solution {
    public boolean check(int[] nums) {

        int n = nums.length;

        int rotation = 0;

        for(int i = 0; i < n; i++){

            // int x = 1;

            if(nums[i] > nums[(i+1) % n]){
                // x++;
                rotation++;
            }
        }
        
        return rotation <= 1;
    }
}