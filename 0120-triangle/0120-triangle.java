class Solution {

    int n;
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {

        n = triangle.size();

        dp = new Integer[n + 1][n + 1];

        return helper(0, 0, triangle);
     
    }

    private int helper(int i, int j, List<List<Integer>> list){
        if(i == n - 1){
            return list.get(i).get(j);
        }

        if(dp[i][j] != null) return dp[i][j];
        

        int first = list.get(i).get(j) + helper(i + 1, j, list);
        int  second = list.get(i).get(j) + helper(i + 1, j + 1, list);

        return dp[i][j] = Math.min(first, second);

        
    }
}