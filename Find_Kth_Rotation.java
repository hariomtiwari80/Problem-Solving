class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<arr[idx]){
                idx=i;
            }
        }
        return idx;
    }
}
