class Solution {
    public int maxProfitAssignment(int[] diff, int[] pro, int[] w) {
        int ans=0;
        for(int x:w){
            ans+=find(diff,pro,x);
        }
        return ans;
    }
    public int find(int[] diff,int[] pro,int x){
        int max=0;
        for(int i=0;i<diff.length;i++){
            if(diff[i]<=x){
                max=Math.max(max,pro[i]);
            }
        }
        return max;
    }
}

-----------------------------------------------------------------------------------

class Solution {
    class pair{
        int d,p;
        pair(int d,int p){
            this.d=d;
            this.p=p;
        }
    }
    public int maxProfitAssignment(int[] diff, int[] pro, int[] w) {
        int n=diff.length,m=w.length;
        pair[] pa=new pair[n];
        for(int i=0;i<n;i++){
            pa[i]=new pair(diff[i],pro[i]);
        }
        Arrays.sort(pa,(a,b)->a.d-b.d);
        Arrays.sort(w);
        int ans=0;
        for(int x:w){
            int max=0;
            for(int i=0;i<n;i++){
                if(pa[i].d>x) break;
                max=Math.max(max,pa[i].p);
            }
            ans+=max;
        }
        return ans;
    }
}

------------------------------------------------------------------------

class Solution {
    class pair{
        int d,p;
        pair(int d,int p){
            this.d=d;
            this.p=p;
        }
    }
    public int maxProfitAssignment(int[] diff, int[] pro, int[] w) {
        int n=diff.length,m=w.length;
        pair[] pa=new pair[n];
        for(int i=0;i<n;i++){
            pa[i]=new pair(diff[i],pro[i]);
        }
        Arrays.sort(pa,(a,b)->a.d-b.d);
        Arrays.sort(w);
        int ans=0,j=0, max=0;
        for(int x:w){
            while(j<n && pa[j].d<=x){
                max=Math.max(max,pa[j].p);
                j++;
            }
            ans+=max;
        }
        return ans;
    }
}

