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
// Q.144
// Given the root of a binary tree, return the preorder traversal of its nodes' values.


class PreordrTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
         if (root == null ) return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;       
        while(true) {        
            if(current == null) {
                if(stack.size()==0) break;
                current = stack.pollLast();            
            }  
            result.add(current.val);
            if(current.right!=null) stack.add(current.right);
            current = current.left;
        }        
        return result;
    }
}
