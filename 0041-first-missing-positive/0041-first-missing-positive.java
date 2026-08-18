class Solution {
    public int firstMissingPositive(int[] nums) {
        int  n = nums.length;
        Arrays.sort(nums);
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int i = 1; i <= nums[n - 1]; i++){

            if(!set.contains(i)){
                return i;
            }


        }
        return nums[n-1] < 1 ? 1 : nums[n - 1] +1;
        
    }
}