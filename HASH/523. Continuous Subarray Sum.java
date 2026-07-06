class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        int n=arr.length;
        if(n<2) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=sum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2) return true;
            }
            if(!map.containsKey(rem)) map.put(rem,i);
        }
        return false;
    }
}
