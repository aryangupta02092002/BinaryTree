/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                Node tmp = q.remove();
                
                if(i < sz-1){
                    tmp.next = q.peek();
                }
                
                if(tmp.left != null){
                    q.offer(tmp.left);
                }
                if(tmp.right != null){
                    q.offer(tmp.right);
                }
            }
        }
        return root;
    }
}
