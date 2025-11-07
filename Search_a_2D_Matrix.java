class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length,c=matrix[0].length,idx=0;
        for(int i=0;i<r;i++){
            if(matrix[i][c-1]==target) return true;
            else if(matrix[i][c-1]>target){
                idx=i;
                break;
            }
        }
        int l=0,h=c-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(matrix[idx][m]==target) return true;
            else if(matrix[idx][m]>target) h=m-1;
            else l=m+1;
        }
        return false;
    }
}
