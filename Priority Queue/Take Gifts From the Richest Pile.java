class Solution {
    public long pickGifts(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(k-->0){
            int t=pq.poll();
            pq.add((int)Math.floor(Math.sqrt(t)));
        }
        long sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}
