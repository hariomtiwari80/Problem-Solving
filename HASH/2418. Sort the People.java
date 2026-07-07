class Solution {
    public String[] sortPeople(String[] n, int[] h) {
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=0;i<n.length;i++){
            map.put(h[i],n[i]);
        }
        Arrays.sort(h);
        int j=0;
        for(int i=h.length-1;i>=0;i--){
            String s=map.get(h[i]);
            n[j++]=s;
        }
        return n;
    }
}
