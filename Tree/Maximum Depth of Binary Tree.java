class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int n=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            n++;
        }
        return n;
    }
}

--------------------------------------------------------------

class Solution {
    public int maxDepth(TreeNode root) {
        return find(root);
    }
    public int find(TreeNode root){
        if(root==null) return 0;
        int left=find(root.left);
        int right=find(root.right);
        return Math.max(left,right)+1;
    }
}
