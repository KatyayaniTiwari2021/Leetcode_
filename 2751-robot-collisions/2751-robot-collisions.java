class Solution {
    public List<Integer> survivedRobotsHealths(int[] position, int[] health, String directions) {

        int n = position.length;

        Integer[] indices = new Integer[n];

        for(int i = 0; i < n; i++){
            indices[i] = i;
        }
        
        //jis index pe postion ki value chhoti hogi wo sabse pehle ayegi 
        Arrays.sort(indices,(left, right) -> Integer.compare(position[left], position[right]));

        Stack<Integer> st = new Stack<>();

        for(int currIdx : indices){
            //right moving robots ko stack me add krenge

            if(directions.charAt(currIdx) == 'R'){
                st.push(currIdx);
            }
            else{
                while(!st.isEmpty() && health[currIdx] > 0){
                    
                    //pop the top robot from the stack for collision check
                    int topIdx = st.pop();

                    //1. top robot is removed and currRobot will survive

                    if(health[currIdx] > health[topIdx]){
                        health[currIdx]--;
                        health[topIdx] = 0;

                    }
                    //currRbot will removed and top robot will survived
                    else if(health[currIdx] < health[topIdx]){
                        health[topIdx]--;
                        health[currIdx] = 0;
                        st.push(topIdx);
                    }
                    //both will removed
                    else{

                        health[topIdx] = 0;
                        health[currIdx] = 0;

                    }
                }
            }     
        }
        //collecting the surviving robots

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(health[i] > 0){
                    list.add(health[i]);
                }
            }

        return list;
        
    }
}