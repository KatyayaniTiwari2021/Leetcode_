class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitude = new int[n + 1];

        for(int i = 1; i <= n; i++){
            altitude[i] = altitude[i- 1] + gain[i - 1];

        }

        Arrays.sort(altitude);

        return altitude[n];
        
    }
}