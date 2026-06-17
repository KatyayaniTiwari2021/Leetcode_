class Solution {
    public int[] countBits(int n) {

        int[] ans = new int[n + 1];

        for(int i = 0; i <= n; i++){
            ans[i] = countones(i);
        }

        return ans;
        
    }
    private int countones(int num){
        int count = 0;

        int n = num;

        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}