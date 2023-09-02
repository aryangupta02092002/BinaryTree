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
    public TreeNode findSuccessor(TreeNode root, int key) {
        if(root == null){
          return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null){
                q.offer(curr.right);
            }
            if(curr.val == key){
                break;
            }
        }
        return q.peek();
    }
}
