class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put((long)num, map.getOrDefault((long)num, 0) + 1);
        }

        int res = 0;

        int ones = map.getOrDefault(1L, 0);

        if(ones % 2 == 0) res += ones- 1;
        else{
            res += ones;
        }


        for(long num : map.keySet()){
            if(num == 1) continue;

            long curr = num;
            int len = 0;

            while(map.getOrDefault(curr, 0) > 1){
                len += 2;
                curr = curr *curr;
            }

            len +=  map.containsKey(curr) ? 1 : -1;

            res = Math.max(res, len);
        }

        return res;
                 

        
        
    }
}