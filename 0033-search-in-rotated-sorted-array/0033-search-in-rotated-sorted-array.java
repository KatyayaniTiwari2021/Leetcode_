class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;

        int piv = pivot(nums);

        if(piv == -1){

            return bs(nums, target, 0, n-1);

        }

        if(nums[piv] == target){
            return piv;
        }

        if(target >= nums[0]){

            return bs(nums, target, 0, piv-1);

        }

        return bs(nums, target, piv + 1, n-1);

       
        
        
    }

    public int bs(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                return mid;
            }
        }

        return -1;

    }

    private int pivot(int[] nums){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid < high && nums[mid] > nums[mid+1]){
                return mid ;
            }
            else if(mid > low && nums[mid] < nums[mid-1]){
                return mid - 1;
            }

            if(nums[low] >= nums[mid]){

                high = mid - 1;

            }else {
                low = mid + 1;
            }

            
        }
        return -1;
    }
}