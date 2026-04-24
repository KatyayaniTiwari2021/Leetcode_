class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
    
        int n = pairs.length;

        int count = 1;

        int prev = pairs[0][1];

        for(int i = 0; i < n; i++){
            if(prev < pairs[i][0]) {
                count++;
                prev = pairs[i][1];
            }
        }

        return count;
        
    }
}