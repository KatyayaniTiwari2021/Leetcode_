class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;

        int max = 0;
        for(int pile : piles){
            max = Math.max(pile, max);
        }

        int ans = 0;

        

        while(min <= max){

            int mid = min + ( max - min)/2;

            if(solve(piles, mid, h)){

                ans = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }

        return ans;
        
    }

    public boolean solve(int[] piles, int mid, int h){

        long hrs = 0;

        for(int pile : piles){
            hrs += (pile + mid - 1)/mid;
        }

        return hrs <= h;







    }
}