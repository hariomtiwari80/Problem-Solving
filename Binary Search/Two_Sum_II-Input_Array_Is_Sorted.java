class Solution {
    public int[] twoSum(int[] arr, int t) {
        int n=arr.length;
        int[] ans=new int[2];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==t){
                    ans[0]=i+1;
                    ans[1]=j+1;
                    return ans;
                }
            }
        }
        return ans;
    }
}

-------------------------------------------

  class Solution {
    public int[] twoSum(int[] arr, int t) {
        int n=arr.length;
        int[] ans=new int[2];
        for(int i=0;i<n-1;i++){
            int l=i+1,h=n-1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(arr[i]+arr[m]==t){
                    ans[0]=i+1;
                    ans[1]=m+1;
                    return ans;
                }
                else if(arr[i]+arr[m]<t) l=m+1;
                else h=m-1;
            }
        }
        return ans;
    }
}
