class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        for(int i=0;i<arr1.length;i++){
            boolean b=true;
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    b=false;
                    break;
                }
            }
            if(b) c++;
        }
        return c;
    }
}

------------------------------------------------------------------------------

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            boolean b=search(arr1[i],arr2,d);
            if(b==true) c++;
        }
        return c;
    }
    public boolean search(int n,int[] arr,int d){
        int l=0,h=arr.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(Math.abs(arr[m]-n)<=d) {
                return false;
            }
            if (arr[m]<n) {
                l=m+1;
            } else {
                h=m-1;
            }
        }
        return true;
    }
}
