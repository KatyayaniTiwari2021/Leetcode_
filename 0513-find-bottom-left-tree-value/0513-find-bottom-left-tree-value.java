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
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result = levelOrder(root);

        List<Integer> ans = result.get(result.size()-1);
        int res = 0;

        for(int val : ans){
            // if(val != null){
                res = val;
                break;
            //}
        }

        return res;



        
    }
    private List<List<Integer>> levelOrder(TreeNode root){
        
        List<List<Integer>> result = new ArrayList<>();

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
            result.add(list);
        }
        return result;
    }
}