class Solution {
    public int min;
    public int[] loudAndRich(int[][] arr, int[] q) {
        int n=q.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] a:arr){
            adj.get(a[1]).add(a[0]);
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            min=-1;
            dfs(adj,new boolean[n],i,q);
            ans[i]=min;
        }
        return ans;
    }
    public void dfs(List<List<Integer>> adj,boolean[] vis,int n,int[] q){
        vis[n]=true;
        for(int i:adj.get(n)){
            if(!vis[i]) dfs(adj,vis,i,q);
        }
        if(min==-1) min=n;
        else if(q[min]>q[n]){
            min=n;
        }
    }
}
