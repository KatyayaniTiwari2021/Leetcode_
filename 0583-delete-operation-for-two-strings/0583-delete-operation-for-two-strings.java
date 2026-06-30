class Solution {
    int n;
    int m;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();

        int  LCS = lcs(word1, word2);

        return n + m - 2 * LCS;        
    }

    private int lcs(String s1, String s2){

        int[][] dp = new int[n+1][m +1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j- 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];

        

    }
}