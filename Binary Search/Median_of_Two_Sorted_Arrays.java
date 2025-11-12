class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n=arr1.length,m=arr2.length;
        List<Integer> l=new ArrayList<>();
        for(int x:arr1){
            l.add(x);
        }
        for(int x:arr2){
            l.add(x);
        }
        Collections.sort(l);
        int i=0,j=l.size()-1;
        while(i<j){
            i++;
            j--;
        }
        return (double)(l.get(i)+l.get(j))/2;
    }
}
