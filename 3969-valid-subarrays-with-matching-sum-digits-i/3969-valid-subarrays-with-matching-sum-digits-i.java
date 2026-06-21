class Solution {
    public int countValidSubarrays(int[] nums, int x) {

        int n = nums.length;
        

        int count = 0;

        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++){

                sum += nums[j];

                String num = Long.toString(sum);
                char ch = (char)(x + '0');

                if(num.charAt(0) == ch && num.charAt(num.length() - 1) == ch){
                    count++;
                }

            }
        }
        return count;

        
        
    }
}