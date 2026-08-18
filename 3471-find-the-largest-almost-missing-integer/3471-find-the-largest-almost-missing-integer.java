class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){

            max = Math.max(num, max);

            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        if(k == n) return max;

        int ans = -1;

        for(int num : nums){
            
            if(k == 1){

                if(map.get(num) == 1){
                    ans = Math.max(ans, num);
                    
                }
                
            }
            else if (k > 1 && k < n){

                if(map.get(nums[0]) == 1 && map.get(nums[n - 1]) == 1){
                    ans = Math.max(nums[0], nums[n - 1]);
                }

                else if(map.get(nums[0]) > 1 && map.get(nums[n - 1]) == 1){
                    ans = nums[n - 1];

                }
                else if(map.get(nums[n - 1]) > 1 && map.get(nums[0]) == 1){
                    ans =  nums[0];
                }


            }
        }
        return  ans;
        
        
    }
}