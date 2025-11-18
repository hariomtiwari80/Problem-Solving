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

