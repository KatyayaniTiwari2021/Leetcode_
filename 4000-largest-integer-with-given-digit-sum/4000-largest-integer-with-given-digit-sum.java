class Solution {
    public int largestInteger(int n, int s) {

        if(s > 9 * n) return -1;

        if(s == 0) return 0;

        int sum = 0;
        int num = 99999;

        for(int i = 1; i <= num; i++){

            String str = Integer.toString(i);
            if(str.length() == n && digitSum(i) == s){
                sum = Math.max(sum, i);

            }
            
        }
        return sum;
        
    }
    public int digitSum(int n){
        int num = n;

        int sum = 0;
        while(num > 0){

            sum += (num % 10);
            num /= 10;

        }
        return sum;
    }
}