class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if(arr.length<k) return 0;
        int sum=0;
        int i=0,j=0;
        while(j<k){
            sum+=arr[j];
            j++;
        }
        int c=0;
        if((sum/k)>=threshold) c++;
        while(j<arr.length){
            sum+=arr[j];
            sum-=arr[i];
            i++;
            j++;
            if((sum/k)>=threshold) c++;
        }
        return c;
    }
}
