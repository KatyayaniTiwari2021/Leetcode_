class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;

        int count = 0;

        // Arrays.sort(intervals, (a, b) -> {
        //     if (a[1] == b[1]) {
        //         return Integer.compare(b[0], a[0]); // first column descending
        //     }
        //     return Integer.compare(a[1], b[1]); // second column ascending
        // });

        for(int i = 0; i < n; i++){

            for(int j = 0; j  < n; j++){

                if(i != j){

                    int a = intervals[i][0];
                    int b = intervals[i][1];
                    int c = intervals[j][0];
                    int d = intervals[j][1];

                    if(c <= a && b <= d){
                        count++;
                        break;
                    }

                }

            }
            

            
        }

        return n - count;
        
    }
}