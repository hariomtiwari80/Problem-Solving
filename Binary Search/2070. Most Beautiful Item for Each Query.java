class Solution {
    public int[] maximumBeauty(int[][] item, int[] q) {
        Arrays.sort(item,(a,b)->Integer.compare(a[0],b[0]));
        int max=-1;
        for(int i=0;i<item.length;i++){
            if(item[i][1]>max) max=item[i][1];
            item[i][1]=max;
        }
        for(int i=0;i<q.length;i++){
            int idx=find(item,q[i]);
            if(idx==-1) q[i]=0;
            else q[i]=item[idx][1];
        }
        return q;
    }
    public int find(int[][] arr,int t){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m][0]>t) h=m;
            else l=m+1;
        }
        if(l-1<0) return -1;
        return l-1;
    }
}
