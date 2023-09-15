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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        boolean leftToright = false;
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> curr = new ArrayList<>(sz);
            for(int i=0; i<sz; i++){
                TreeNode currNode = q.remove();
                curr.add(currNode.val);

                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
            if(leftToright){
                Collections.reverse(curr);
            }
            ans.add(curr);
            leftToright = !leftToright;
        }
        return ans;
    }
}
