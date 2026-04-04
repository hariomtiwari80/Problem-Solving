class Solution {
    public boolean isBipartite(int[][] arr) {
        int n=arr.length;
        int[] temp=new int[n];
        Arrays.fill(temp,-1);
        for(int i=0;i<n;i++){
            if(temp[i]==-1){
                if(!bfs(arr,temp,i)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] arr,int[] temp,int n){
        Queue<Integer> q=new LinkedList<>();
        q.add(n);
        temp[n]=n;
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i:arr[t]){
                if(temp[i]==-1){
                    if(temp[t]==0){
                        temp[i]=1;
                    }
                    else{
                        temp[i]=0;
                    }
                    q.add(i);
                }
                else if(temp[i]==temp[t]) return false;
            }
        }
        return true;
    }
}
