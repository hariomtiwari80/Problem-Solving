public class Solution {
    public bool CanThreePartsEqualSum(int[] arr) {
        int n=arr.Length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum%3!=0) return false;
        int tar=sum/3;
        int temp=0,c=0;
        for(int i=0;i<n-1;i++){
            temp+=arr[i];
            if(temp==tar){
                c++;
                temp=0;
            }
            if(c==2){
                return true;
            }
        }
        return false;
    }
}
