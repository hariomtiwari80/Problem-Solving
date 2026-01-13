class Solution {
    class pair{
        int r,c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int orangesRotting(int[][] arr) {
        int no=0,n=arr.length,m=arr[0].length;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==2) q.add(new pair(i,j));
                else if(arr[i][j]==1) no++;
            }
        }
        if(no==0) return 0;
        int ans=0;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                pair p=q.poll();
                int r=p.r,c=p.c;
                for(int[] a:dir){
                    int nr=r+a[0],nc=c+a[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && arr[nr][nc]==1){
                        arr[nr][nc]=2;
                        q.add(new pair(nr,nc));
                        no--;
                    }
                }
            }
            ans++;
        }
        if(no==0) return ans-1;
        return -1;
    }
}
