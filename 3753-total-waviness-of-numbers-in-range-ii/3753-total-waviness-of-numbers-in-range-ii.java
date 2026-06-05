class Solution {

    long[][][][] dpCount;
    long[][][][] dpWave;
    boolean[][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return waves(num2) - waves(num1 - 1);
    }

    public long waves(long num) {

        if(num <= 0) return 0;

        String s = Long.toString(num);
        int n = s.length();

        dpCount = new long[n][2][11][11];
        dpWave  = new long[n][2][11][11];
        vis     = new boolean[n][2][11][11];

        long[] ans = helper(s, 0, 1, 1, -1, -1);

        return ans[1];
    }

    public long[] helper(String s, int idx, int tight,
                         int lz, int last, int secondLast) {

        if(idx == s.length()){
            return lz == 1 ? new long[]{0,0}
                           : new long[]{1,0};
        }

        if(tight == 0 &&
           vis[idx][lz][last + 1][secondLast + 1]) {

            return new long[]{
                dpCount[idx][lz][last + 1][secondLast + 1],
                dpWave[idx][lz][last + 1][secondLast + 1]
            };
        }

        int upper = tight == 1 ? s.charAt(idx) - '0' : 9;

        long totalCount = 0;
        long totalwaves = 0;

        for(int i = 0; i <= upper; i++){

            long wave = 0;

            int newlast;
            int newSecondLast;

            if(lz == 1){

                newlast = (i == 0) ? -1 : i;
                newSecondLast = -1;

            }else{

                newlast = i;
                newSecondLast = last;

                if(secondLast != -1){
                    if((last > secondLast && last > i) ||
                       (last < secondLast && last < i)){
                        wave = 1;
                    }
                }
            }

            int newTight = (tight == 1 && i == upper) ? 1 : 0;
            int newlz = (lz == 1 && i == 0) ? 1 : 0;

            long[] res = helper(
                    s,
                    idx + 1,
                    newTight,
                    newlz,
                    newlast,
                    newSecondLast
            );

            totalCount += res[0];
            totalwaves += res[1] + res[0] * wave;
        }

        if(tight == 0){

            vis[idx][lz][last + 1][secondLast + 1] = true;

            dpCount[idx][lz][last + 1][secondLast + 1] = totalCount;
            dpWave[idx][lz][last + 1][secondLast + 1] = totalwaves;
        }

        return new long[]{totalCount, totalwaves};
    }
}