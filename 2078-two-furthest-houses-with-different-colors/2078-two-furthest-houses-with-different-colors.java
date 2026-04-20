class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int distance = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(colors[i] != colors[j]){
                    distance = Math.max(distance, Math.abs(j - i));
                }
            }
        }
        return distance;
        
    }
}