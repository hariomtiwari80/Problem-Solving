class Solution {
    public boolean isZeroArray(int[] arr, int[][] q) {
        int n=arr.length;
        for(int[] a:q){
            for(int j=a[0];j<=a[1];j++){
                arr[j]-=1;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>0) return false;
        }
        return true;
    }
}

-------------------------------------------------------------

class Solution {
    public boolean isZeroArray(int[] arr, int[][] q) {
        int n=arr.length;
        int[] t=new int[n];
        for(int[] a:q){
            t[a[0]]+=1;
            if(a[1]+1<n) t[a[1]+1]-=1;
        }
        int s=t[0];
        for(int i=1;i<n;i++){
            t[i]+=s;
            s=t[i];
        }
        for(int i=0;i<n;i++){
            arr[i]-=t[i];
            if(arr[i]>0) return false;
        }
        return true;
    }
}
