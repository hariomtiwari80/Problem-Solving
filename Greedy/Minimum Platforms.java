class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0,c=0,max=0;
        while(i<arr.length){
            if(arr[i]<=dep[j]){
                c++;
                max=Math.max(max,c);
                i++;
            }
            else if(arr[i]>dep[j]){
                c--;
                j++;
            }
        }
        return max;
    }
}
