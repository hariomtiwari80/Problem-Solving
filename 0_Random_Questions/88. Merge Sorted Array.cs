public class Solution {
    public void Merge(int[] arr1, int m, int[] arr2, int n) {
        int len=m+n;
        int idx=arr1.Length-1;
        int i=m-1,j=n-1;
        while(i>=0 && j>=0){
            if(arr1[i]>arr2[j]){
                arr1[idx--]=arr1[i--];
            }
            else{
                arr1[idx--]=arr2[j--];
            }
        }
        while(i>=0){
            arr1[idx--]=arr1[i--];
        }
        while(j>=0){
            arr1[idx--]=arr2[j--];
        }
    }
}
