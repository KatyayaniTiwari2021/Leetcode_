class Solution {
    public int maxProduct(int[] nums) {
        int maxi = nums[0];
        int min = nums[0];

        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = maxi;  //min ko update krne se pehle max ko store kr liya so that jab hm min calculate krne ke time pe uodated max ki value na ho usme

            maxi = Math.max(Math.max(maxi * nums[i] , min * nums[i]), nums[i]);

            min =  Math.min(Math.min(temp * nums[i] , min * nums[i]), nums[i]);

            if(ans < maxi){
                ans = maxi;
            }
        }

        return ans;
        
    }
}