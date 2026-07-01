class Solution {
    public int[] findIntersectionValues(int[] arr1, int[] arr2) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int n:arr1){
            set1.add(n);
        }
        for(int n:arr2){
            set2.add(n);
        }
        int ans1=0,ans2=0;
        for(int i:arr1){
            if(set2.contains(i)) ans1++;
        }
        for(int i:arr2){
            if(set1.contains(i)) ans2++;
        }
        return new int[]{ans1,ans2};
    }
}
