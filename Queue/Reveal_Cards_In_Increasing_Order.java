class Solution {
    public int[] deckRevealedIncreasing(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Queue<Integer> q=new LinkedList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int idx=0;
        while(!q.isEmpty()){
            ans[q.remove()]=arr[idx++];
            if(!q.isEmpty()) q.add(q.remove());
        }
        return ans;
    }
}
