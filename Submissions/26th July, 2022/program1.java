/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// 236. Lowest Common Ancestor of a Binary Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root==null||root==p||root==q) return root; 
        
        //recursive relation on both children
        TreeNode lc=lowestCommonAncestor(root.left,p,q);
        TreeNode rc=lowestCommonAncestor(root.right,p,q);
        
        //conditions to print result
        if(lc!=null && rc!=null) return root; //if both sides are !null
        else if(lc!=null) return lc; //if lc is !null
        else return rc; //if rc is !null

    }
}