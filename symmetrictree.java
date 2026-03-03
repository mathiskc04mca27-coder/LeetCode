class Solution {
    public boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null) {
            return true;
        }
        
        // Compare the left subtree and the right subtree
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case: both are null, so they are mirrors
        if (t1 == null && t2 == null) return true;
        
        // Base case: one is null and the other isn't, not mirrors
        if (t1 == null || t2 == null) return false;
        
        // Check three conditions:
        // 1. Values must be equal
        // 2. Left of t1 mirrors Right of t2
        // 3. Right of t1 mirrors Left of t2
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}
