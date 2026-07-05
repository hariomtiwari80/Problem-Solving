class Solution {
    public int minSubarray(int[] arr, int p) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=n;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int rem=(int)(sum%p);
        if(rem==0) return 0;
        map.put(0,-1);
        int curr=0;
        for(int i=0;i<n;i++){
            curr=(curr+arr[i])%p;
            int temp=(curr-rem+p)%p;
            if(map.containsKey(temp)) min=Math.min(min,i-map.get(temp));
            map.put(curr,i);
        }
        if(min==n) return -1;
        return min;
    }
}
