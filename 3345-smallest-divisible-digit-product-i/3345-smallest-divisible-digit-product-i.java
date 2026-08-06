class Solution {
    public int smallestNumber(int n, int t) {

        int ans = 0;

        for(int i = n; i <= n * t; i++){
            if(product(i) % t == 0){
                ans = i;
                break;
            }
        }
        return ans;
        
    }

    private int product(int num){
        int pro = 1;
        while(num > 0){
            pro *= num % 10;
            num /= 10;
        }
        return pro;
    }

    
}