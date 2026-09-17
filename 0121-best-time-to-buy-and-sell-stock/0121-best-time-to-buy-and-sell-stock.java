class Solution {
    public int maxProfit(int[] prices) {
        int BuysPrice=prices[0];
        int MaxProfit= 0;
        for(int i=1;i< prices.length;i++){
            if(BuysPrice>prices[i]){
                BuysPrice = prices[i];
            }else{
                int CP = prices[i]-BuysPrice;
                MaxProfit = Math.max(MaxProfit,CP);
            }
            
        }
        return MaxProfit;
        
    }

}