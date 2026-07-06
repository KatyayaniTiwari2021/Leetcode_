class Solution {
    public int maxDigitRange(int[] nums) {

        int max = 0;

        int sum = 0;

        for(int num : nums){
            int digit_range =  largest(num) - smallest(num);

            if(max < digit_range){
                max = digit_range;
            }

        }

        for(int num : nums){
            int digit_range = largest(num) - smallest(num);

            if(digit_range == max){
                sum += num;
            }
        }

        return sum;

        
        
    }

    private int largest(int num){

        int max = 0;

        while(num > 0){
            int rem = num % 10;

            if(max < rem){
                max = rem;
            }

            num /= 10;
        }

        return max;
    }

    private int smallest(int num){

        int min = 10;

        while(num > 0){
            int rem = num % 10;

            if(min > rem){
                min = rem;
            }

            num /= 10;
        }
        
        return min;
    }
}