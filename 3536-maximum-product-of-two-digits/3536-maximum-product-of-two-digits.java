class Solution {
    public int maxProduct(int n) {

        int num = n;

        int max1 = 0;
        int max2 = 0;

        while(num > 0){

            int rem = num % 10;

            if(rem > max1){

                max2 = max1;
                max1 = rem;

            }
            else if(rem > max2){
                max2 = rem;
            }
            

            num /= 10;
        }

        
        return max2 * max1;
        
    }
}