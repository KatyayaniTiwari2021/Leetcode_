class Solution {
    public int countValidPrefixes(String s) {

        int n = s.length();

        int cnt = 0;

        for(int j = 1; j <= n; j++){

            int cnt1 = 0;
            int cnt2 = 0;

            String sub  = s.substring(0, j);

            for(int i = 0; i < sub.length(); i++){
                if(sub.charAt(i) == '0')cnt2++;
                else cnt1++;
            }

            if(Math.abs(cnt1 - cnt2) <= 1) cnt++;

        }
        return cnt;
    }
}