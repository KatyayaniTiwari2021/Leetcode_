class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        long diff = 1L* (max  - min) * k;

        return diff;
        
    }
}