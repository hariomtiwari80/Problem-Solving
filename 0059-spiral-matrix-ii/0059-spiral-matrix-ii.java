class Solution {
    public int[][] generateMatrix(int n) {
        
        int [][] arr = new int [n][n];

        int count = 1;

        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = n - 1;

         while(count <= n*n){
            for(int col = minCol; col <= maxCol; col++){
                arr[minRow][col] = count;
                count++;
            }

            for(int row = minRow + 1; row <= maxRow; row++){
                arr[row][maxCol] = count;
                count++;
            }

            for(int col = maxCol - 1; col >= minCol; col--){
                arr[maxRow][col] = count;
                count++;
            }

            for(int row = maxRow - 1; row >= minRow + 1; row--){
                arr[row][minCol] = count;
                count++;
            }

            minCol++;
            maxCol--;
            minRow++;
            maxRow--;
         }
         return arr;
    }
}