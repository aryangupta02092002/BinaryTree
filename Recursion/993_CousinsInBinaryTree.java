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
    int x_dep = -1, y_dep = -1, x_par = -1, y_par = -1;

    public void depth(TreeNode root, int x, int y, int dep, int par){
        if(root == null){
            return;
        }
        if(root.val == x){
            x_dep = dep;
            x_par = par;
        }
        if(root.val == y){
            y_dep = dep;
            y_par = par;
        }
        if(x_dep != -1 && y_dep != -1){
            return;
        }

        depth(root.left, x, y, dep+1, root.val);
        depth(root.right, x, y, dep+1, root.val);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        depth(root, x, y, 0, -1);
        return x_dep == y_dep && x_par != y_par;
    }
}
