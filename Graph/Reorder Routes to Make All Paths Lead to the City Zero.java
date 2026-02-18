class Solution {
    public int minReorder(int n, int[][] arr) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:arr){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
            if(map.containsKey(a[0])){
                map.get(a[0]).add(a[1]);
            }
            else{
                map.put(a[0],new HashSet<>());
                map.get(a[0]).add(a[1]);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        int ans=0;
        boolean[] vis=new boolean[n];
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int t=q.poll();
            for(int a:adj.get(t)){
                if(!vis[a]){
                    if(map.containsKey(t) && map.get(t).contains(a)) ans++;
                    vis[a]=true;
                    q.add(a);
                }
            }
        }
        return ans;
    }
}
