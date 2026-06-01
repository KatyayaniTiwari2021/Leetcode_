class Solution {
    public boolean detectCapitalUse(String word) {

        int n = word.length();

        int capital = 0;
        int small = 0;

        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);

            if(Character.isUpperCase(ch)){
                capital++;
                
            }
            else{
                small++;
            }
        }

        if(capital == n || small == n ) return true;
        if(capital == 1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }

        return false;
        
    }
}