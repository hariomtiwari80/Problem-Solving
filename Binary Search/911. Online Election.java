class TopVotedCandidate {
    public HashMap<Integer,Integer> map;
    public int[] time;
    public int[] ans;
    public TopVotedCandidate(int[] arr, int[] times) {
        time=times;
        map=new HashMap<>();
        ans=new int[arr.length];
        int max=-1;
        int ele=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>=max){
                max=map.get(arr[i]);
                ele=arr[i];
            }
            ans[i]=ele;
        }
    }
    
    public int q(int t) {
        int l=0,h=time.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(time[m]>t) h=m;
            else l=m+1;
        }
        return ans[l-1];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
