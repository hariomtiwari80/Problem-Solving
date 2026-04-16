class Solution {
    public int largestInteger(int n) {
       PriorityQueue<Integer> even=new PriorityQueue<>(Collections.reverseOrder()); 
       PriorityQueue<Integer> odd=new PriorityQueue<>(Collections.reverseOrder());
       int x=n;
       while(x!=0){
        int r=x%10;
        if(r%2==0) even.add(r);
        else odd.add(r);
        x/=10;
       }
       int ans=0;
       String s=""+n;
       for(int i=0;i<s.length();i++){
        if((s.charAt(i)-'0')%2==0){
            ans*=10;
            ans+=even.poll();
        }
        else{
            ans*=10;
            ans+=odd.poll();
        }
       }
       return ans;
    }
}
