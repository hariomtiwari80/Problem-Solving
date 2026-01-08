class Solution {
    class pair{
        int w,v;
        double d;
        pair(double d,int w,int v){
            this.d=d;
            this.w=w;
            this.v=v;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int cap) {
        int n=val.length;
        double ans=0;
        if(n<=0) return ans;
        pair[] p=new pair[n];
        for(int i=0;i<n;i++){
            double div=(double)val[i]/wt[i];
            p[i]=new pair(div,wt[i],val[i]);
        }
        Arrays.sort(p,(a,b)->Double.compare(a.d,b.d));
        for(int i=n-1;i>=0;i--){
            if(cap==0) break;
            if(cap<p[i].w){
                ans+=((double)cap/p[i].w) * p[i].v;
                break;
            }
            else{
                ans+=p[i].v;
                cap-=p[i].w;
            }
        }
        
        return ans;
    }
}
