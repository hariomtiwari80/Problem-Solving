class Solution {
    public int[] findOrder(int n, int[][] arr) {
        int[] in=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
            in[arr[i][0]]++;
        }
        List<Integer> l=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
                l.add(i);
                c++;
            }
        }
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i:adj.get(t)){
                in[i]--;
                if(in[i]==0){
                    c++;
                    q.add(i);
                    l.add(i);
                }
            }
        }
        if(c!=n) return new int[]{};
        int[] ans=new int[n];
        for(int i=0;i<l.size();i++){
            ans[i]=l.get(i);
        }
        return ans;
    }
}
