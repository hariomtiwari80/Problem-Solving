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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    public TreeNode delete(TreeNode root,int val){
        if(root==null) return null;
        if(root.val>val){
            root.left=delete(root.left,val);
        }
        else if(root.val<val){
            root.right=delete(root.right,val);
        }
        else{
            if(root.left==null && root.right==null) return null;
            else if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else{
                TreeNode temp=min(root.right);
                root.val=temp.val;
                root.right=delete(root.right,temp.val);
            }
        }
        return root;
    }
    public TreeNode min(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
