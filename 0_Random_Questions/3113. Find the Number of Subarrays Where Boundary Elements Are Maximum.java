class Solution {
    public long numberOfSubarrays(int[] arr) {
        int n=arr.length;
        long ans=0;
        Stack<int[]> st=new Stack<>();
        for(int x:arr){
            int c=1;
            while(!st.isEmpty() && st.peek()[0]<x) st.pop();
            if(!st.isEmpty() && st.peek()[0]==x){
                c+=st.peek()[1];
                st.peek()[1]=c;
            }
            else st.push(new int[]{x,c});
            ans+=c;
        }
        return ans;
    }
}
