class Solution {
    public long countBadPairs(int[] arr) {
        long n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        long c=0;
        for(int i=0;i<n;i++){
            int curr=arr[i]-i;
            if(map.containsKey(curr)) c+=map.get(curr);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        long ans=((n*(n-1))/2)-c;
        return ans;
    }
}
