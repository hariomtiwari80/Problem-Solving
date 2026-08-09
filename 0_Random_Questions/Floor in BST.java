/*
Definition for Node
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
    public int findMaxFork(Node root, int k) {
        int ans=-1;
        while(root!=null){
            if(root.data==k) return k;
            else if(root.data>k) root=root.left;
            else{
                ans=Math.max(ans,root.data);
                root=root.right;
            }
        }
        return ans;
    }
}
