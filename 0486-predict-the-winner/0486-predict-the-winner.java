class Solution {
    public boolean predictTheWinner(int[] nums) {

        return helper(0, nums.length - 1, nums) >= 0;
        
    }

    private int helper(int i, int j, int[] nums){
        if(i == j) return nums[i];

        int left = nums[i]  - helper(i + 1, j, nums);

        int right = nums[j]  - helper(i, j - 1, nums);

        return Math.max(left, right);
    }
}