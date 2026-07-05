class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int c=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=sum%k;
            if(rem<0) rem+=k;
            if(map.containsKey(rem)) c+=map.get(rem);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }   
        return c;
    }
}
