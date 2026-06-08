class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> larger = new ArrayList<>();
        ArrayList<Integer> equal  = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                smaller.add(nums[i]);
            }
            else if(nums[i] > pivot){
                larger.add(nums[i]);
            }
            else{
                equal.add(nums[i]);
            }

        }

        int n = smaller.size() + larger.size() + equal.size();

        int[] res = new int[n];

        for(int i = 0; i < smaller.size(); i++){
            res[i] = smaller.get(i);
        }
        for(int i = 0; i < equal.size(); i++){
            res[i+ smaller.size()] = equal.get(i);

        }
        for(int i = 0; i < larger.size(); i++){
            res[i + smaller.size()+equal.size()] = larger.get(i);
        }

        return res;
        
    }
}