class Solution {
    public int minPatches(int[] arr, int n) {
        int c=0,i=0;
        long miss=1;
        while(miss<=n){
            if(i<arr.length && arr[i]<=miss){
                miss+=arr[i];
                i++;
            }
            else{
                c++;
                miss+=miss;
            }
        }
        return c;
    }
}
