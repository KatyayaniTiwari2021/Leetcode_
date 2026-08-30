class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if(n == 1) return 1;

        int max = -(int)1e9;
        int min = (int)1e9;

        int maxIdx = 0;
        int minIdx = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i] < min ){
                min = nums[i];
                minIdx = i;
            }

        }

        int front = Math.max(minIdx, maxIdx);
        int back =  Math.min(minIdx, maxIdx);

        return Math.min(back + n - front  + 1, Math.min(front + 1, n - back ));

        
    }
}