class Solution {
    public int minOperations(int[] nums, int x) {  

        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(x == 0) return n;
        
        int target = sum - x;

        if(target < 0) return -1;

        int left = 0;
        int currSum = 0;
        int maxLen = -1;

        for(int right = 0; right < n; right++){
            currSum += nums[right];

            while(currSum > target){
                currSum -= nums[left];
                left++;

            }

            if(currSum == target){
                maxLen = Math.max(maxLen, right - left + 1);
            }

        }

        return maxLen == -1 ? -1 : n -  maxLen;

        
    }
}