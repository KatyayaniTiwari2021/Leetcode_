class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        HashSet<Integer> result = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }

        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }

        int[] arr = new int[result.size()];
        
        int k = 0;
        for(int num : result){
            arr[k++] = num; 

        }

        return arr;

        

        
    }
}