class Solution {
    public int singleNonDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            int val = mp.getValue();

            if(val == 1){
                return mp.getKey();
            }
        }
        
        return -1;
    }
}