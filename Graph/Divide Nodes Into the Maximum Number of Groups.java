class Solution {
    public int magnificentSets(int n, int[][] path) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<path.length;i++){
            adj.get(path[i][0]-1).add(path[i][1]-1);
            adj.get(path[i][1]-1).add(path[i][0]-1);
        }
        int ans=0;
        int[] dis=new int[n];
        Arrays.fill(dis,-1);
        for(int i=0;i<n;i++){
            List<Integer> l=new ArrayList<>();
            if(dis[i]==-1){
                if(!bip(adj,i,dis,l)) return -1; 
            }
            int max=0;
            for(int j:l){
                max=Math.max(max,depth(adj,j,n));
            }
            ans+=max;
        }
        return ans;
    }
    public boolean bip(List<List<Integer>> adj,int n,int[] dis,List<Integer> l){
        Queue<Integer> q=new LinkedList<>();
        q.add(n);
        dis[n]=0;
        while(!q.isEmpty()){
            int t=q.poll();
            l.add(t);
            for(int i:adj.get(t)){
                if(dis[i]==-1){
                    if(dis[t]==0){
                        dis[i]=1;
                    }
                    else dis[i]=0;
                    q.add(i);
                }
                else if(dis[i]==dis[t]) return false;
            }
        }
        return true;
    }
    public int depth(List<List<Integer>> adj,int n,int m){
        boolean[] vis=new boolean[m];
        vis[n]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(n);
        int c=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int temp=q.poll();
                for(int k:adj.get(temp)){
                    if(!vis[k]){
                        q.add(k);
                        vis[k]=true;
                    }
                }
            }
            c++;
        }
        return c;
    }
}
