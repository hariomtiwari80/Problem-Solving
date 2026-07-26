class Solution {
    public long makeSimilar(int[] arr, int[] t) {
        int n=arr.length;
        Arrays.sort(arr);
        List<Integer> even=new ArrayList<>();
        List<Integer> odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(t[i]%2==0) even.add(t[i]);
            else odd.add(t[i]);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int i=0,j=0;
        long c=0;
        for(int k=0;k<n;k++){
            if(arr[k]%2==0){
                c+=Math.abs(arr[k]-even.get(i));
                i++;
            }
            else{
                c+=Math.abs(arr[k]-odd.get(j));
                j++;
            }
        }
        return c/4;
    }
}
