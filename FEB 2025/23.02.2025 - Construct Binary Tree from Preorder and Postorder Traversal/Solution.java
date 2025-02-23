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
    // Keep track of the preorder index
    private int preIndex = 0;
    // Map to store value -> index mapping for postorder array
    private Map<Integer, Integer> postMap;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Create a map to store indices of elements in postorder traversal
        postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        
        // Start the recursive construction
        return construct(preorder, 0, postorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int postStart, int postEnd) {
        // Base case: if we've processed all nodes or invalid range
        if (postStart > postEnd || preIndex >= preorder.length) {
            return null;
        }
        
        // Create the current node from preorder traversal
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        // If we've reached a leaf node
        if (postStart == postEnd) {
            return root;
        }
        
        // Find the index of next preorder element in postorder traversal
        // This will help us determine the left subtree's range
        int index = postMap.get(preorder[preIndex]);
        
        // If the index is within valid range, construct left and right subtrees
        if (index >= postStart) {
            // Construct left subtree from postStart to index
            root.left = construct(preorder, postStart, index);
            // Construct right subtree from index+1 to postEnd-1 
            // (excluding the root which is at postEnd)
            root.right = construct(preorder, index + 1, postEnd - 1);
        }
        
        return root;
    }
}