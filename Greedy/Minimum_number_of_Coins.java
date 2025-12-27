class Solution {
    public int findMin(int n) {
        int ans=0;
        int[] arr={10,5,2,1};
        for(int i=0;i<arr.length;i++){
            int d=n/arr[i];
            if(d!=0){
                ans+=d;
                n-=arr[i]*d;
            }
        }
        return ans;
    }
}
