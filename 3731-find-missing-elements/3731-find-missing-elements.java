class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = nums[0]; i < nums[n-1]; i++){
            if(!set.contains(i)){
                list.add(i);
            }

            
        }
        Collections.sort(list);

        return list;

        
    }
}