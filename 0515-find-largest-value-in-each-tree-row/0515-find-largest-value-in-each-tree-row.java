/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        List<List<Integer>> list = levelOrder(root);

        for(List<Integer> l : list){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < l.size(); i++){
                if(l.get(i) > max){
                    max = l.get(i);

                }       
            }
            res.add(max);
        }
        return res;

        
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();
            
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);

                if(curr.left != null ){
                    q.offer(curr.left);
                }
                
                if(curr.right != null ){
                    q.offer(curr.right);
                }

            }
            res.add(list);
        }
        return res;
        
    }
}