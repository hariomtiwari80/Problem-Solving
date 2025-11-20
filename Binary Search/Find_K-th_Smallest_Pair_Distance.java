class Solution {
    public int smallestDistancePair(int[] arr, int k) {
        List<Integer> l=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                l.add(Math.abs(arr[i]-arr[j]));
            }
        }
        Collections.sort(l);
        return l.get(k-1);
    }
}-------TLE

------------------------------------------------------------

class Solution {
    public int smallestDistancePair(int[] arr, int k) {
        Arrays.sort(arr);
        int l=0,h=arr[arr.length-1]-arr[0];
        int ans=h;
        while(l<=h){
            int m=l+(h-l)/2;
            int p=find(arr,m);
            if(p<k) l=m+1;
            else{
                ans=m;
                h=m-1;
            }
        }
        return ans;
    }
    public int find(int[] arr,int m){
        int cnt=0;
        for(int i=0;i<arr.length-1;i++){
            int j=i+1;
            while(j<arr.length && arr[j]-arr[i]<=m){
                j++;
            }
            cnt+=j-i-1;
        }
        return cnt;
    }
}
