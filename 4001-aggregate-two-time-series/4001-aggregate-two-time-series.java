class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {

        int n = series1.length;
        int m = series2.length;

        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < n && j < m){

            List<Integer> list = new ArrayList<>();

            if(series1[i][0] < series2[j][0]){
                list.add(series1[i][0]);
                list.add(series1[i][1] + series2[j][1]);
                i++;
            }
            else if (series1[i][0] > series2[j][0]){
                list.add(series2[j][0]);
                list.add(series2[j][1] + series1[i][1]);
                j++;
            }
            else{
                list.add(series1[i][0]);
                list.add(series1[i][1] + series2[j][1]);
                i++;
                j++;
            }

            

            res.add(list);
        }

       

        while(i < n){
            res.add(Arrays.asList(series1[i][0],series1[i][1]));
            i++;

        }
        while(j < m){
            res.add(Arrays.asList(series2[j][0],series2[j][1]));
            j++;
        }

        

        return res;

        
        
    }
    
}