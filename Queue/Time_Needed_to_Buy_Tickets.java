class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int ans=0;
        while(!q.isEmpty()){
            int t=q.remove();
            arr[t]--;
            ans++;
            if(arr[t]!=0) q.add(t);
            if(arr[k]==0) return ans;
        }
        return ans;
    }
}
