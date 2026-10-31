class Solution {
    public int[][] merge(int[][] arr) {
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int start=arr[0][0],end=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]>end){
                List<Integer> temp=new ArrayList<>();
                temp.add(start);
                temp.add(end);
                System.out.println(start+" "+end);
                l.add(temp);
                start=arr[i][0];
                end=arr[i][1];
            }
            else{
                end=Math.max(end,arr[i][1]);
            }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(start);
        temp.add(end);
        l.add(temp);
        int[][] ans=new int[l.size()][2];
        for(int i=0;i<l.size();i++){
            ans[i][0]=l.get(i).get(0);
            ans[i][1]=l.get(i).get(1);
        }
        return ans;
    }
}
