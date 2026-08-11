class Solution {
    public int missingInteger(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        
        int sum  = nums[0];

        for(int  j = 1; j < nums.length; j++){
           
            if(nums[j] != nums[j-1]+1){
                break;

            }else{
                sum += nums[j];
            }


        }

        while(set.contains(sum)){
            sum++;
        }
        return sum;

        
    }
}