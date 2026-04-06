class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] arr) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        Stack<Integer> st=new Stack<>();
        int min=n;
        for(int i=0;i<n;i++){
            int t=depth(adj,i,n);
            if(t<min){
                min=t;
                while(!st.isEmpty()) st.pop();
                st.push(i);
            }
            else if(t==min) st.push(i);
        }
        List<Integer> l=new ArrayList<>();
        while(!st.isEmpty()){
            l.add(st.pop());
        }
        Collections.sort(l);
        return l;
    }
    public int depth(List<List<Integer>> adj,int i,int n){
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        vis[i]=true;
        int c=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int t=q.poll();
                for(int j:adj.get(t)){
                    if(!vis[j]){
                        q.add(j);
                        vis[j]=true;
                    }
                }
            }
            c++;
        }
        return c;
    }
}

------------------------------------------------------------------

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] arr) {
        ArrayList<Integer> l=new ArrayList<>();
        if(n==1) {
            l.add(0);
            return l;
        }
        int[] in=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][1]).add(arr[i][0]);
            in[arr[i][0]]++;
            in[arr[i][1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==1) q.add(i);
        }
        while(n>2){
            int size=q.size();
            n-=size;
            for(int i=0;i<size;i++){
                int t=q.poll();
                for(int j:adj.get(t)){
                    in[j]--;
                    if(in[j]==1) q.add(j);
                }
            }
        }
        while(!q.isEmpty()) l.add(q.poll());
        return l;
    }
}
