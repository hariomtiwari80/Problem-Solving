class Solution {
    public ArrayList<Integer> minMaxCandy(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int i=0,j=n-1,min=0;
        while(i<=j){
            min+=arr[i];
            j-=k;
            i++;
        }
        int max=0;
        i=n-1;j=0;
        while(i>=j){
            max+=arr[i];
            j+=k;
            i--;
        }
        ans.add(min);
        ans.add(max);
        return ans;
    }
}
