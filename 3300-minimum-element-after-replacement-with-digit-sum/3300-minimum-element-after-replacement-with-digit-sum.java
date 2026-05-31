class Solution {
    public int minElement(int[] nums) {

        for(int i = 0; i < nums.length; i++){

            nums[i] = digitSum(nums[i]);

        }

        Arrays.sort(nums);

        return nums[0];
        
    }

    private int digitSum(int num){
        int sum = 0;

        while(num > 0){

            int rem = num % 10;

            sum += rem;

            num /= 10;

        }
        return sum;
    }
}