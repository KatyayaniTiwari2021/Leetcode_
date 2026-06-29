class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int cnt = 0;

        for(int i = 0; i < patterns.length; i++){

            if(isSubstring(patterns[i], word)){
                cnt++;
            }

        }
        return cnt;
        
    }
    public boolean isSubstring(String s1, String s2){

        for(int i = 0; i < s2.length(); i++){

            boolean flag = false;

            for(int j = i; j < s2.length(); j++){

                String sub = s2.substring(i, j+1);

                if(s1.equals(sub)){
                    flag = true;
                    break;
                }
            }
            if(flag){
            return true;
        }
        }

        

        return false;

    }
}