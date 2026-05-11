class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            String s = String.valueOf(num);

            for(int i = 0; i < s.length(); i++){
                int temp = s.charAt(i) -'0';
                list.add(temp);
            }
           
        }
        

        int[] arr = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }

        return arr;
        
    }

    
}