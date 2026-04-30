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
    public int maxLevelSum(TreeNode root) {

        List<List<Integer>> list = levelOrder(root);

        int[] max = new int[list.size()];

        for(int i = 0; i < list.size(); i++){

            int sum = 0;

            for(int num : list.get(i)){
                sum += num;
            }

            max[i] = sum;
            
        }
        int maxSum = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < max.length; i++){
            if(max[i] > maxSum){
                maxSum =  max[i];
                index = i;
            }
        }
        return index + 1;
        
    }
    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return res;

        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();

                list.add(curr.val);

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }

            res.add(list);
        }

        return res;
    }
}