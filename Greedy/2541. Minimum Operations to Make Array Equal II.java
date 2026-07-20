class Solution {
    public long minOperations(int[] arr1, int[] arr2, int k) {
        int n=arr1.length;
        if(k==0){
            if(Arrays.equals(arr1,arr2)) return 0;
            else return -1;
        }
        long neg=0,pos=0;
        for(int i=0;i<n;i++){
            int diff=arr1[i]-arr2[i];
            if(diff%k!=0) return -1;
            if(diff<0) neg+=diff;
            else if(diff>0) pos+=diff;
        }
        if(pos+neg!=0) return (long)-1;
        return (pos/k);
    }
}
