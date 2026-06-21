class Solution {
    public String[] createGrid(int m, int n) {

        String[] arr  = new String[m];

        for(int i = 0; i < m - 1 ; i++){
            StringBuilder sb = new StringBuilder();

            sb.append('.');

            for(int j = 1; j < n; j++){
                sb.append('#');
            }

            arr[i] = sb.toString();
        }
        
        String str = "";
        for(int i = 0; i < n; i++){
            str += ".";
            
        }
        arr[m - 1] = str;

        return arr;
        
    }
}