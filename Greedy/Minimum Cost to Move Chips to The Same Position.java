class Solution {
    public int minCostToMoveChips(int[] arr) {
        int even=0,odd=0;
        for(int x:arr){
            if(x%2==0) even++;
            else odd++;
        } 
        return Math.min(even,odd);
    }
}
