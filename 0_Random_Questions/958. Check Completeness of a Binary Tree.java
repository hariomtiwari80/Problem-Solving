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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean b=false;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode t=q.poll();
                if(b && (t.left!=null || t.right!=null)) return false;
                if(t.left==null && t.right!=null) return false;
                if(t.left!=null) q.add(t.left);
                if(t.right==null) b=true;
                else q.add(t.right);
            }
        }
        return true;
    }
}
