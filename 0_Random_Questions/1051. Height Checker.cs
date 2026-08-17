public class Solution {
    public int HeightChecker(int[] arr) {
        int[] exp=new int[arr.Length];
        for(int i=0;i<arr.Length;i++) exp[i]=arr[i];
        Array.Sort(exp);
        int c=0;
        for(int i=0;i<arr.Length;i++){
            if(arr[i]!=exp[i]) c++;
        }
        return c;
    }
}
