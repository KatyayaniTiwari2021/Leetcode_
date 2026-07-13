class Solution {
    public boolean lemonadeChange(int[] bills) {

        int n = bills.length;

        int five = 0;
        int ten = 0;

        for(int num : bills){
            if(num == 5){
                five++;
            }
            else if(num == 10){
                ten++;

                if(five == 0) {
                    return false;
                }

                else{
                    five--;
                }
                
            }
            else{

                if(five < 1) return false;

                else if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }

                else if(ten < 1 && five >= 3){
                    five-=3;    
                    
                }
                else if(ten < 1 && five < 3){
                    return false;
                }
               
                
            }
        }
        return true;
        
    }
}