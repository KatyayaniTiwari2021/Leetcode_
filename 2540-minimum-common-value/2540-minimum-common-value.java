class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        long min = (long)1e18;

        long num = 0;

        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                num = nums1[i];
                min = Math.min(min, num);

                i++;
                j++;    
                
            }else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }   

        return min == (long)1e18 ? -1 : (int)min;



        
    }
}