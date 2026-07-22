class Solution {
    public int[] successfulPairs(int[] spell, int[] potion, long success) {
        int n=spell.length,m=potion.length;
        int[] ans=new int[n];
        Arrays.sort(potion);
        for(int i=0;i<n;i++){
            int idx=find(potion,spell[i],success);
            ans[i]=m-idx;
        }
        return ans;
    }
    public int find(int[] arr,int t,long s){
        int l=0,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if((long)arr[m]*t>=s) h=m;
            else l=m+1;
        }
        return l;
    }
}
