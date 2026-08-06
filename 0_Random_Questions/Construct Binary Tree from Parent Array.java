
/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    Node createTree(int[] arr) {
        Queue<Node> q=new LinkedList<>();
        Node root=null;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                root=new Node(i);
                q.add(root);
                break;
            }
        }
        while(!q.isEmpty()){
            Node t=q.poll();
            int l=-1,r=-1;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==t.data){
                    if(l==-1) l=i;
                    else{
                        r=i;
                        break;
                    }
                }
                    
            }
            if(l!=-1){
                t.left=new Node(l);
                q.add(t.left);
            }
            if(r!=-1){
                t.right=new Node(r);
                q.add(t.right);
            }
        }
        return root;
    }
}
