class Solution {
    class Pair{
        double frac;
        int idx;
        Pair(double frac,int idx){
            this.frac=frac;
            this.idx=idx;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int cap) {
        int n=val.length;
        Pair[] p=new Pair[n];
        for(int i=0;i<n;i++){
            p[i]=new Pair((double)val[i]/wt[i],i);
        }
        Arrays.sort(p,(a,b)->Double.compare(b.frac,a.frac));
        double ans=0.000000;
        for(int i=0;i<n;i++){
            int v=val[p[i].idx];
            int w=wt[p[i].idx];
            if(w<=cap){
                ans+=v;
                cap-=w;
            }
            else{
                ans+=(((double)cap/w)*v);
                break;
            }
        }
        return ans;
    }
}
