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
class FindElements {
    private HashSet<Integer> values;
    
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recoverTree(root, 0);
    }
    
    private void recoverTree(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        
        // Recover current node's value and add to set
        node.val = value;
        values.add(value);
        
        // Recursively recover left and right subtrees
        // For left child: 2 * x + 1
        // For right child: 2 * x + 2
        recoverTree(node.left, 2 * value + 1);
        recoverTree(node.right, 2 * value + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
