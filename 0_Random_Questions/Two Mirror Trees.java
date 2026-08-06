/* Tree Node Structure
class Node
{
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
} */

class Solution {
    boolean areMirror(Node a, Node b) {
        if(a==null && b==null) return true;
        if((a==null && b!=null) || (a!=null && b==null) || (a.data!=b.data)) return false;
        return areMirror(a.left,b.right) && areMirror(a.right,b.left);
    }
}
