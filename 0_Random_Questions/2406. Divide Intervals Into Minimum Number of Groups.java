class Solution {
    public int minGroups(int[][] arr) {
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(arr[0][1]);
        int c=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]>pq.peek()){
                pq.poll();
            }
            else{
                c++;
            }
            pq.add(arr[i][1]);
        }
        return c;
    }
}
