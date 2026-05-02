class Solution {
    public int rotatedDigits(int n) {

        int count = 0;

        for(int i = 1; i <= n; i++){

            int num = i;

            boolean isValid = true;
            boolean hasChanged = false;

            while(num > 0){

                int digit = num % 10;

                if(digit == 3 || digit == 4 || digit == 7){
                    isValid = false;
                    break;
                }
                if(digit == 2 || digit == 5 || digit == 6 || digit == 9){
                    hasChanged = true;
                }
               

                num /= 10; //yha num change ho rha isliye hm i ko num me store krayenge

            }
            if(isValid && hasChanged){
                count++;
            }

        }
        return count;
        
    }
}