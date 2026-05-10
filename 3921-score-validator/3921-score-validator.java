class Solution {
    public int[] scoreValidator(String[] events) {

        int n = events.length;

        int[] ans = new int[2];  // a[0] = score, //a[1] = counter

        for(int i = 0; i < n; i++){

            if(events[i] .equals ("0") || events[i] .equals("1")||events[i] .equals("2")||events[i] .equals("3")||events[i] .equals("4")||events[i] .equals("5")||events[i] .equals("6")){
                int val = Integer.valueOf(events[i]);
                ans[0] += val;
            }
            if(events[i] .equals("W")){
                ans[1]++;
                if(ans[1] == 10) break;
                
            }

            if(events[i] .equals("WD")|| events[i] .equals("NB")){
                ans[0] +=1;
            }

        }

        return ans;
        
    }
}