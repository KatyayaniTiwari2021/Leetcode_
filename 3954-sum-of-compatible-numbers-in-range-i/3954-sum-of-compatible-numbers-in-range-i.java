class Solution {
    public int sumOfGoodIntegers(int n, int k) {

        int compatible = 0;

        for(int i = 1; i <= 200; i++){
            if(Math.abs(n - i) <= k && (n & i) == 0){
                compatible += i;
            }
        }
        return compatible;
        
    }
}