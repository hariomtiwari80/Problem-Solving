class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] in=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                in[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int t=q.poll();
            ans.add(t);
            for(int i:adj.get(t)){
                in[i]--;
                if(in[i]==0){
                    q.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
