class Solution {

    static int mod = 1_000_000_007;

    Integer[][] dp;

    public int numberOfWays(int startPos, int endPos, int k) {

        dp = new Integer[2001][3001];

        return solve(0, startPos, endPos, k);
        
    }

    public int solve(int i, int moves,int end, int k){
        if(i == k){
            if(moves == end){
                return 1;
            }
            return 0;
        }

        if(dp[i][moves+1000] != null){
            return dp[i][moves+1000];
        }

        int right = solve(i + 1, moves + 1,end, k);
        int left = solve(i + 1, moves - 1, end, k);

        return dp[i][moves+1000] = (right + left) % mod;
    }
}