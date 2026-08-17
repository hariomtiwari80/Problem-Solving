public class Solution {
    public int LargestAltitude(int[] arr) {
        int max=0;
        int sum=0;
        for(int i=0;i<arr.Length;i++){
            sum+=arr[i];
            max=Math.Max(max,sum);
        }
        return max;
    }
}
