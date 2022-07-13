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
    List<List<Integer>> levels = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        
        recurse(root, 0);
        
        return levels;
    }
    
    private void recurse(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        
        levels.get(level).add(node.val);
        
        if (node.left != null) {
            recurse(node.left, level + 1);
        }
        
        if (node.right != null) {
            recurse(node.right, level + 1);
        }
    }
}



// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution { //iterative solution
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         Queue <TreeNode> q = new LinkedList <TreeNode>();
//       List<List<Integer>> list = new LinkedList <List<Integer>>();
//       if(root == null)
//         return list;
      
//       q.offer(root);
//       while(!q.isEmpty()) {
//         int num = q.size();
//         List<Integer> subList = new LinkedList<Integer>();
//         for(int i = 0; i < num; i ++) {
//           if(q.peek().left != null)
//             q.offer(q.peek().left);
//            if(q.peek().right != null)
//             q.offer(q.peek().right);
//           subList.add(q.poll().val);
//         }
//         list.add(subList);
//       }
//       return list;
//     }
// }