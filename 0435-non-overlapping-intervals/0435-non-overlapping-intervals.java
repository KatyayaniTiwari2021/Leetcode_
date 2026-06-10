class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int minRemoval = 0;

        int prev = intervals[0][1];

        for(int i = 1; i < n ; i++){

            int start = intervals[i][0];

            if( prev > start){
                minRemoval++;
            }
            else{

                prev = intervals[i][1];


            }
            

        }
        return minRemoval;
        
    }
}