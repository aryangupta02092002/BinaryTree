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
    public boolean helper(TreeNode tmpLeft, TreeNode tmpRight){
        if(tmpLeft == null || tmpRight == null){
            return tmpLeft == tmpRight;
        }
        if(tmpLeft.val != tmpRight.val){
            return false;
        }
        return helper(tmpLeft.left, tmpRight.right) && helper(tmpLeft.right, tmpRight.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
}
