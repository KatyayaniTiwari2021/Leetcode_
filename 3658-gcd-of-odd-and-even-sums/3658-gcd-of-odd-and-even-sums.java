class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum = 0;
        int oddSum = 0;

        int temp = n;

        int i = 2;

        while(temp > 0){

            evenSum += i;
            i += 2;
            temp--;
            
        }

        int j = 1;
        while(n > 0){

            oddSum += j;
            j += 2;
            n--;
            
        }

        return gcd(evenSum, oddSum);
        
    }

    private int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }
}