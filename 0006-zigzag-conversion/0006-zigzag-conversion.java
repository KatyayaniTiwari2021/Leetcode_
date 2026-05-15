class Solution {
    public String convert(String s, int numRows) {

        int n = s.length();

        if(numRows == 1 || n == 1) return s;

        List<Character>[] row = new ArrayList[numRows];

        for(int i = 0; i < numRows; i++){
            row[i] = new ArrayList<>();
        }
        
        int idx = 0, direction = 1;  //1 for down ,-1 for up
        for(char c : s.toCharArray()){
            row[idx].add(c);

            if(idx == 0){
                direction = 1;
            }
            else if( idx == numRows - 1){
                direction = -1;
            }

            idx += direction;

        }

        StringBuilder sb = new StringBuilder();
        for(List<Character> list : row){
            for(char c : list){
                sb.append(c);
            }
        }

        return sb.toString();


        
    }
}