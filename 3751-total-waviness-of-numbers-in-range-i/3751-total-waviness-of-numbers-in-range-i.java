class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;

        for(int i = num1; i <= num2; i++){
            String n = String.valueOf(i);

            waviness += solve(n);

        }
        return waviness;
    
    }
    public int solve(String s){
        int n = s.length();

        int count = 0;

        for(int i = 1; i < n - 1; i++){
            int prev = s.charAt(i - 1)- '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i+1)- '0';

            if(curr > prev && curr > next){
                count++;
            }
            if(curr < prev && curr < next){
                count++;
            }

        }
        return count;
    }
}