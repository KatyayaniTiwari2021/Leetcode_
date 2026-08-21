class Solution {
    public int wiggleMaxLength(int[] nums) {

        if(nums.length < 2) return nums.length; 

        int cnt = 1;
        int prevDiff = nums[1] - nums[0];

        if(prevDiff != 0){
            cnt = 2;
        }

        for(int i = 2; i < nums.length; i++){

            int currDiff = nums[i] - nums[i - 1];

            boolean inc = false;
            boolean dec = false;

            if(prevDiff >= 0 && currDiff < 0){
                inc = true;
                prevDiff = currDiff;

            }else if(prevDiff <= 0 && currDiff > 0){
                dec = true;
                prevDiff = currDiff;
            }

            if(inc || dec) cnt++;

        }
        return cnt;


        
    }
}