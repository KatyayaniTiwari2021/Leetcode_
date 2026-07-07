class Solution {
    Integer[][] dp1;
    Integer[][] dp2;

    static int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int m = board.get(0).length();

        dp1 = new Integer[101][101];
        dp2 = new Integer[101][101];

        
        int max = solve(n - 1, m - 1, board);

        if(max < 0){
            return new int[]{0,0};
        }

        int ways = totalPath(n - 1, m - 1,board);

        return new int[]{max, ways % MOD};
        
    }

    public int solve(int i, int j, List<String> list){

        if(i < 0 || j < 0) return -(int)1e9;

        if((list.get(i)).charAt(j) == 'X') return -(int)1e9;

        if(i == 0 && j == 0){
            return 0;
        }

       

        if(dp1[i][j]!= null){
            return dp1[i][j];
        }
        
        int val = 0;

        char ch = list.get(i).charAt(j);

        if(ch >= '0' && ch <= '9'){

            val = ch - '0';

        }

        int up = solve(i - 1, j, list);
        int left = solve(i, j-1, list);
        int up_left = solve(i - 1, j-1, list);

        int best = Math.max(up, Math.max(left, up_left));

        return dp1[i][j] = best + val;


    }

    public int totalPath(int i, int j, List<String> list){
        if(i < 0 || j < 0) return 0;

        if((list.get(i)).charAt(j) == 'X') return 0;

        if(i == 0 && j == 0){
            return 1;
        }

        if(dp2[i][j] != null){
            return dp2[i][j];
        }
        
        int val = 0;

        char ch = list.get(i).charAt(j);

        if(ch >= '0' && ch <= '9'){

            val = ch - '0';

        }

        int up = solve(i - 1, j, list);
        int left = solve(i, j-1, list);
        int up_left =  solve(i - 1, j-1, list);

        int score = Math.max(up, Math.max(left, up_left));

        long ways = 0;
        if(up == score){
            ways += totalPath(i - 1, j, list);
        }

        if(left == score){
            ways += totalPath(i, j- 1, list);
        }

        if(up_left == score){
            ways += totalPath(i - 1, j-1,  list);
        }

        return dp2[i][j] = (int)(ways % MOD);

    }
}