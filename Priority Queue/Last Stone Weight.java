class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int t1=pq.poll();
            int t2=pq.poll();
            if(t1==t2) continue;
            else{
                pq.add(Math.abs(t1-t2));
            }
        }
        if(pq.size()==0) return 0;
        return pq.poll();
    }
}
