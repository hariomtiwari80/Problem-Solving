class Solution {
    public int countCompleteComponents(int m, int[][] arr) {
        int n=arr.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:arr){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        int ans=0;
        boolean[] vis=new boolean[m];
        for(int i=0;i<m;i++){
            if(!vis[i]){
                boolean b=bfs(adj,vis,i);
                if(b) ans++;
            }
        }
        return ans;
    }
    public boolean bfs(List<List<Integer>> adj,boolean[] vis,int i){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        vis[i]=true;
        int v=0,e=0;
        while(!q.isEmpty()){
            int t=q.poll();
            v++;
            for(int a:adj.get(t)){
                e++;
                if(!vis[a]){
                    vis[a]=true;
                    q.add(a);
                }
            }
        }
        return e==v*(v-1);
    }
}
