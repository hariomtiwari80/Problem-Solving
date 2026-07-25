class Solution {
    public long countFairPairs(int[] arr, int lower, int upper) {
        int n=arr.length;
        Arrays.sort(arr);
        long c=0;
        for(int i=0;i<n;i++){
            int min=lower-arr[i];
            int max=upper-arr[i];
            int lb=lowerBound(arr,i+1,min);
            int ub=upperBound(arr,i+1,max);
            c+=ub-lb;
        }
        return c;
    }
    public int lowerBound(int[] arr,int s,int t){
        int l=s,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>=t) h=m;
            else l=m+1;
        }
        return l;
    }
    public int upperBound(int[] arr,int s,int t){
        int l=s,h=arr.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr[m]>t) h=m;
            else l=m+1;
        }
        return l;
    }
}
