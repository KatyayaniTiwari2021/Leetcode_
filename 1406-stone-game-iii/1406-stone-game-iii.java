class Solution {
    Integer[] dp;
    int n;
    public String stoneGameIII(int[] stoneValue) {

        n = stoneValue.length;

        dp = new Integer[n + 1];

        int alice_score = helper(0, stoneValue);

        int sum = 0;

        for(int num : stoneValue){
            sum += num;
        }

        int bob_score = sum - alice_score;

        int ans = alice_score - bob_score;

        if(ans == 0) return "Tie";
        else if(ans > 0) return "Alice";

        return "Bob";
        
    }
    private int helper(int i, int[] nums){
       
        if(i  >= n ) return 0;

        if(dp[i] != null){
            return dp[i];
        }

        int one = nums[i] + Math.min(helper(i + 2, nums), Math.min(helper(i + 3, nums), helper(i + 4, nums)));


        int two = -(int)1e9;

        if(i + 1 < n){
            two = nums[i] + nums[i + 1] + Math.min(helper(i + 3, nums),Math.min(helper(i + 4, nums), helper(i + 5,nums)));

        }
        
        int three = -(int)1e9;
        if(i + 2 < n){
        
            three = nums[i] + nums[i + 1] + nums[i + 2] + 
            Math.min(helper(i + 4, nums),Math.min(helper(i + 5,nums),helper(i + 6 ,nums)));
        }

        return dp[i] = Math.max(one, Math.max(two,  three));
    }
}