class Solution {
    public int minimumPushes(String word) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : word.toCharArray()){

            map.put(ch, map.getOrDefault(ch, 0)+1);

        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int ans = 0;
        int n = list.size();

        for(int i = 0; i < n; i++){

            int value = list.get(i).getValue();

            int push = i / 8 + 1;

            ans += value * push;

        }
        return ans;


        
        
    }
}