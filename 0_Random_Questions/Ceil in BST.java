class Solution {
    int findCeil(Node root, int x) {
        int ans=Integer.MAX_VALUE;
        while(root!=null){
            if(root.data==x) return x;
            else if(root.data<x) root=root.right;
            else{
                ans=Math.min(ans,root.data);
                root=root.left;
            }
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
