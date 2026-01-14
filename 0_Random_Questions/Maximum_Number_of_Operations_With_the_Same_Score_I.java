class Solution {
    public int maxOperations(int[] arr) {
        int sum=arr[0]+arr[1];
        int c=1;
        for(int i=2;i<arr.length-1;i+=2){
            if(arr[i]+arr[i+1]==sum) c++;
            else break;
        }
        return c;
    }
}
