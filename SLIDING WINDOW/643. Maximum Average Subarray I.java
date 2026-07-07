class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int n=arr.length;
        int sum=0;
        double max=-1e10;
        int i=0,j=0;
        while(j<n){
            sum+=arr[j];
            if(j-i+1==k){
                double temp=(double)(sum)/k;
                max=Math.max(max,temp);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return max;
    }
}
