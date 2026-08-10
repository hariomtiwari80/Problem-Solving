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
    public int c=0,ans=0;
    public int kthSmallest(TreeNode root, int k) {
        smallest(root,k);
        return ans;
    }
    public void smallest(TreeNode root,int k){
        if(root==null) return;
        smallest(root.left,k);
        c++;
        if(c==k){
            ans=root.val;
            return;
        }
        smallest(root.right,k);
    }

}
