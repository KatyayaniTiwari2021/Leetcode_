class Solution {
    public boolean checkGoodInteger(int n) {

        int digitSum = 0;
        int SquareSum = 0;

        while(n > 0){
            int rem = n % 10;

            digitSum += rem;
            SquareSum += (rem * rem);

            n /= 10;

        }

        return (SquareSum - digitSum) >= 50;
        
    }
}