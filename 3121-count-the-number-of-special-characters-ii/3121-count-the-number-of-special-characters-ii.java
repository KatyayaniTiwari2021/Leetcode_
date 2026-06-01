class Solution {
    public int numberOfSpecialChars(String word) {

        HashMap<Character, Integer> lower = new HashMap<>();

        HashMap<Character, Integer> upper = new HashMap<>();


        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(Character.isUpperCase(ch)){
                upper.putIfAbsent(ch, i);
            }
            else{
                lower.put(ch, i);
            }
        }

        int count = 0;

        for(char ch = 'a'; ch <= 'z'; ch++){
            char up = Character.toUpperCase(ch);

            if(lower.containsKey(ch) && upper.containsKey(up)){
                if(lower.get(ch) < upper.get(up)){
                    count++;
                }
            }

        }
        return count;

        

        


        
    }
}