/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null) {
            return false;
        }

        
        if (root.left == null && root.right == null) {
            // If it's a leaf, check if the remaining sum matches the leaf's value
            return targetSum == root.val;
        }

       
        int remainingSum = targetSum - root.val;
        
        // Use OR (||) because we only need ONE path to be valid
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
