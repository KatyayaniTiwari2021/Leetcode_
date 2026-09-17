class Solution {
    public int maxProfit(int[] prices) {

        int buy = prices[0];

        int max = 0;

        for(int i = 0; i < prices.length; i++){

            if(buy > prices[i]){

                buy = prices[i];
            }
            else{

                int sell = prices[i] - buy;

                max = Math.max(max, sell);

            }
        }

        return max;
        
    }
}