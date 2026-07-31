class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        for(int i = 0 ; i < 26 ; i++){
            freq[i] = 0;
        }
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq,Collections.reverseOrder());
        int ans = 0 ;

        for(int i = 0 ; i < 26 ; i++){
            int Freq = freq[i];
            int press = i/8 + 1;
            ans += Freq*press;

        }
        return ans;
        
    }
}