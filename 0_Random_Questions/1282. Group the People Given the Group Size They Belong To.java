class Solution {
    public List<List<Integer>> groupThePeople(int[] group) {
        int n=group.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=group[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> ans=new ArrayList<>();
        int i=0;
        while(i<n){
            List<Integer> l=new ArrayList<>();
            int max=i+arr[i][0];
            while(i<max){
                l.add(arr[i][1]);
                i++;
            }
            ans.add(l);
        }
        return ans;
    }
}
