class Solution {
    public int longestSubarray(int[] arr, int limit) {
        Deque<Integer> max=new ArrayDeque<>();
        Deque<Integer> min=new ArrayDeque<>();
        int ans=0;
        int i=0,j=0;
        while(j<arr.length){
            while(!max.isEmpty() && arr[max.peekLast()]<=arr[j]) max.pollLast();
            while(!min.isEmpty() && arr[min.peekLast()]>=arr[j]) min.pollLast();
            max.addLast(j);
            min.addLast(j);
            while(arr[max.peekFirst()]-arr[min.peekFirst()]>limit){
                if(max.peekFirst()==i) max.pollFirst();
                if(min.peekFirst()==i) min.pollFirst();
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
