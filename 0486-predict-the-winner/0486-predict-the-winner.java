class Solution {
    public boolean predictTheWinner(int[] nums) {

        int total = 0;

        for(int num : nums){
            total += num;
        }

        int player1 = solve(0, nums.length - 1, nums);
        int player2 = total - player1;

        if(player1 > player2 || player1 == player2){
            return true;
        }

        return false;
        
    }

    private int solve(int i , int j, int[] nums){
        if(i > j) return 0;

        if(i == j) return nums[i];

        int first = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j -1, nums));
        int second = nums[j] + Math.min(solve(i, j - 2, nums), solve(i + 1,j-1,nums));

        return Math.max(first, second);
    }
}