class Solution {
    class Pair{
        int num,id;
        Pair(int num,int id){
            this.num=num;
            this.id=id;
        }
    }
    public int[] findRightInterval(int[][] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Pair[] p=new Pair[n];
        for(int i=0;i<n;i++){
            p[i]=new Pair(arr[i][0],i);
        }
        Arrays.sort(p,(a,b)->Integer.compare(a.num,b.num));
        for(int i=0;i<n;i++){
            int idx=find(p,arr[i][1]);
            ans[i]=idx;
        }
        return ans;
    }
    public int find(Pair[] p,int t){
        int l=0,h=p.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(p[m].num<t) l=m+1;
            else h=m;
        }
        if(l>=p.length) return -1;
        return p[l].id;
    }
}
