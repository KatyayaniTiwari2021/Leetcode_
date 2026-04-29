class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;
        
        int capacity = 0;

        for(int i = 0; i < weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(mid, days, weights)){
                capacity = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return capacity;
        
    }

    public boolean isPossible(int k, int days, int[] arr){
        int day = 1;

        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > k){
                day++;
                sum = arr[i];
            }
        }

        if(day <= days){
            return true;
        }

        return false; 

    }
}