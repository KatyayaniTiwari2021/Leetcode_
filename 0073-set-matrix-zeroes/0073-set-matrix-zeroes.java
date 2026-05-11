class Solution {
    public void setZeroes(int[][] matrix) {

        int m =  matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < n; k++){
                        if(matrix[i][k] == 0) continue;
                        matrix[i][k] =  99999999;
                        
                    }
                    for(int x = 0; x < m; x++){
                        if(matrix[x][j] == 0) continue;
                        matrix[x][j] = 99999999;
                       
                    }
                        

                }
               
            }     
        }

        for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == 99999999){
                        matrix[i][j] = 0;
                    }
                }
            }

        
    }
}