class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        int ans = 0;

        for(int num : piles){
            high = Math.max(high, num);
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(mid,  h,  piles)){

                ans = mid;
                high = mid - 1;

            }
            else{

                low = mid + 1;

            }
        }
        return ans;
        
    }

    public boolean isPossible(int mid,int h, int[] piles){

        long hours = 0;
        
        for(int i = 0; i < piles.length; i++){
            hours += (piles[i] + mid - 1)/mid;
        }
        

        if(hours <= h) return true;

        return false;
    }
}