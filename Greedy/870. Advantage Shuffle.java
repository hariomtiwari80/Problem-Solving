class Solution {
    public int[] advantageCount(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int n=arr1.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=arr2[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(b[0],a[0]));
        int[] ans=new int[n];
        int l=0,r=n-1;
        for(int i=0;i<n;i++){
            if(arr1[r]>arr[i][0]){
                ans[arr[i][1]]=arr1[r--];
            }
            else{
                ans[arr[i][1]]=arr1[l++];
            }
        }
        return ans;
    }
}
