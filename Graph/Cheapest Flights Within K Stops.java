class Solution {
    class pair{
        int n,d;
        pair(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    public int findCheapestPrice(int m, int[][] arr, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<m;i++) adj.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            int c=arr[i][2];
            adj.get(a).add(new int[]{b,c});
        }
        int[] ans=new int[m];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(src,0));
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                pair p=q.poll();
                int n=p.n;
                int d=p.d;
                for(int[] i:adj.get(n)){
                    int n1=i[0];
                    int d1=i[1];
                    if(ans[n1]>d+d1){
                        ans[n1]=d+d1;
                        q.add(new pair(n1,d+d1));
                    }
                }
            }
            k--;
            if(k<0) break;
        }
        return ans[dst]==Integer.MAX_VALUE?-1:ans[dst];
    }
}
