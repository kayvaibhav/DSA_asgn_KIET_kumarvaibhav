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

// https://leetcode.com/submissions/detail/743913231/
// 199. Binary Tree Right Side View
class Solution {
    public void dfs(TreeNode root, List<Integer> ans, int depth){
        if(root == null)return;
        
        if(depth == ans.size()) ans.add(root.val);
        
        dfs(root.right,ans,depth+1);
        dfs(root.left,ans,depth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root,ans,0);
        return ans;
        //TLE
        // if(root.val==null) return null;
        // TreeNode head = new TreeNode();
        // head = root;
        // List<Integer> rightView= new ArrayList<>();
        // while(head.right!=null)
        // {
        //     rightView.add(head.val);
        // }
        // return rightView;
    }
}