class Solution {
    int index = 0;  // Global index to track position in traversal string
    
    public TreeNode recoverFromPreorder(String traversal) {
        // Start recursion from depth 0
        return parseNode(traversal, 0);
    }
    
    private TreeNode parseNode(String traversal, int targetDepth) {
        // If we've reached the end of the string, return null
        if (index >= traversal.length()) {
            return null;
        }
        
        // Count dashes to determine current depth
        int currentDepth = 0;
        while (index + currentDepth < traversal.length() && 
               traversal.charAt(index + currentDepth) == '-') {
            currentDepth++;
        }
        
        // If current depth doesn't match target depth, return null
        // This means we're trying to find a child that doesn't exist
        if (currentDepth != targetDepth) {
            return null;
        }
        
        // Skip the dashes
        index += currentDepth;
        
        // Parse the number
        int value = 0;
        while (index < traversal.length() && 
               Character.isDigit(traversal.charAt(index))) {
            value = value * 10 + (traversal.charAt(index) - '0');
            index++;
        }
        
        // Create new node with the parsed value
        TreeNode node = new TreeNode(value);
        
        // Try to parse left child (depth + 1)
        node.left = parseNode(traversal, targetDepth + 1);
        
        // Try to parse right child (depth + 1)
        node.right = parseNode(traversal, targetDepth + 1);
        
        return node;
    }
}

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
