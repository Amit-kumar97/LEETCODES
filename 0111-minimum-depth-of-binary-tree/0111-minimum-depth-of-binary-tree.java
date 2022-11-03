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
    int minVal = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if(node==null)
            return 0;
        int lft = dfs(node.left);
        int rgt = dfs(node.right);
        
        return (lft==0 || rgt==0) ? lft+rgt+1 : Math.min(lft, rgt)+1;
    }
}