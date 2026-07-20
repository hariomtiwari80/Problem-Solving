class Solution {
    public List<Integer> targetIndices(int[] arr, int t) {
        int min=0,c=0;
        for(int x:arr){
            if(x<t) min++;
            else if(x==t) c++;
        }
        List<Integer> ans=new ArrayList<>();
        if(c==0) return ans;
        int max=min+c;
        while(min!=max){
            ans.add(min++);
        } 
        return ans;
    }
}
