class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] row : reservedSeats){
            map.computeIfAbsent(row[0], k -> new ArrayList<>()).add(row[1]);
        }

        int cnt = 2 * n;

        for(int i : map.keySet()){
            
            boolean left = true;
            boolean middle = true;
            boolean  right = true;

            for(int val = 2; val <= 5; val++){
                if(map.get(i).contains(val)){
                    left = false;
                    break;
                }
                
            }
            for(int val = 4; val <= 7; val++){
                if(map.get(i).contains(val)){
                    middle = false;
                    break;
                }
            }

            for(int val = 6;  val <= 9; val++){
                if(map.get(i).contains(val)){
                    right = false;
                    break;
                }
            }

            if(left && right){
                
            }

            else if(left || middle || right){
                cnt --;
            }
            else{
                cnt -= 2;
            }
            
        }

        return cnt;
        
    }
}