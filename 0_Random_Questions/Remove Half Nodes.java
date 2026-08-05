/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node removeHalfNodes(Node root) {
        return find(root);
    }
    public Node find(Node root){
        if(root==null) return null;
        root.left=find(root.left);
        root.right=find(root.right);
        if(root.left==null && root.right==null) return root;
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        return root;
    }
}
