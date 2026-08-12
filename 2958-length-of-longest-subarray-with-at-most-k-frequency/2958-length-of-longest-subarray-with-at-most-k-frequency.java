class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        int left = -1;
        for(int right = 0; right < nums.length; right++){

            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            while(map.get(nums[right]) > k){
                left++;
                map.put(nums[left], map.get(nums[left]) - 1);
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
        
    }
}