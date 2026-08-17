public class Solution {
    public int[] NextGreaterElement(int[] arr1, int[] arr2) {
        Stack<int> st=new Stack<int>();
        Dictionary<int,int> d=new Dictionary<int,int>();
        for(int i=arr2.Length-1;i>=0;i--){
            while(st.Count!=0 && st.Peek()<=arr2[i]) st.Pop();
            if(st.Count!=0){
                d.Add(arr2[i],st.Peek());
            }
            else{
                d.Add(arr2[i],-1);
            }
            st.Push(arr2[i]);
        }
        int[] arr=new int[arr1.Length];
        for(int i=0;i<arr1.Length;i++){
            arr[i]=d[arr1[i]];
        }
        return arr;
    }
}
