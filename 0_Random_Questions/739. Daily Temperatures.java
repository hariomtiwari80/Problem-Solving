public class Solution {
    public int[] DailyTemperatures(int[] arr) {
        Stack<int> st=new Stack<int>();
        int n=arr.Length;
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(st.Count>0 && arr[st.Peek()]<=arr[i]) st.Pop();
            if(st.Count!=0){
                ans[i]=st.Peek()-i;
            }
            st.Push(i);
        }
        return ans;
    }
}
