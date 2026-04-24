class Solution {
    public int lastStoneWeight(int[] stones) {

        int weight = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone :stones){

            q.offer(stone);

        }
        

        while(q.size() > 1){
            int first = q.poll();  //first stone
            int second = q.poll(); // second stone

            if(first != second){
                q.offer(first - second);
            }
        }

        return q.isEmpty() ? 0 : q.peek();
        
    }
}