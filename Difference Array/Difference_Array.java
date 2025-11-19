//Brute Force
class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int[] a:opr){
            int l=a[0],r=a[1],x=a[2];
            for(int i=l;i<=r;i++){
                arr[i]+=x;
            }
        }
        for(int x:arr){
            ans.add(x);
        }
        return ans;
    }
}


----------------------------------------------------------------------------

//Optimal
class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int[] t=new int[n];
        for(int[] a:opr){
            int l=a[0],r=a[1],x=a[2];
            if(l>=0 && l<n) t[l]+=x;
            if(r>=0 && r+1<n) t[r+1]-=x;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=t[i];
            arr[i]+=sum;
            ans.add(arr[i]);
        }
        
        return ans;
    }
}
