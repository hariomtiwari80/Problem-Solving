class Solution {
    public boolean possibleBipartition(int n, int[][] arr) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] a:arr){
            adj.get(a[0]-1).add(a[1]-1);
            adj.get(a[1]-1).add(a[0]-1);
        }
        int[] dis=new int[n];
        Arrays.fill(dis,-1);
        for(int i=0;i<n;i++){
            if(dis[i]==-1){
                if(!bfs(adj,dis,i)) return false;
            }
        }
        return true;
    }
    public boolean bfs(List<List<Integer>> adj,int[] dis,int n){
        Queue<Integer> q=new LinkedList<>();
        q.add(n);
        dis[n]=0;
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i:adj.get(t)){
                if(dis[i]==-1){
                    if(dis[t]==0){
                        dis[i]=1;
                    }
                    else dis[i]=0;
                    q.add(i);
                }
                else{
                    if(dis[t]==dis[i]) return false;
                }
            }
        }
        return true;
    }
}
