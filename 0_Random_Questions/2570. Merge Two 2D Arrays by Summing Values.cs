public class Solution {
    public int[][] MergeArrays(int[][] arr1, int[][] arr2) {
        List<List<int>> l=new List<List<int>>();
        int i=0,j=0;
        while(i<arr1.Length && j<arr2.Length){
            List<int> temp=new List<int>();
            if(arr1[i][0]==arr2[j][0]){
                temp.Add(arr1[i][0]);
                temp.Add(arr1[i][1]+arr2[j][1]);
                i++;
                j++;
            }
            else if(arr1[i][0]>arr2[j][0]){
                temp.Add(arr2[j][0]);
                temp.Add(arr2[j][1]);
                j++;
            }
            else{
                temp.Add(arr1[i][0]);
                temp.Add(arr1[i][1]);
                i++;
            }
            l.Add(temp);
        }
        while(i<arr1.Length){
            List<int> temp=new List<int>();
            temp.Add(arr1[i][0]);
            temp.Add(arr1[i][1]);
            i++;
            l.Add(temp);
        }
        while(j<arr2.Length){
            List<int> temp=new List<int>();
            temp.Add(arr2[j][0]);
            temp.Add(arr2[j][1]);
            j++;
            l.Add(temp);
        }
        int[][] ans=new int[l.Count][];
        for(int k=0;k<l.Count;k++){
            int[] arr=new int[2];
            arr[0]=l[k][0];
            arr[1]=l[k][1];
            ans[k]=arr;
        }
        return ans;
    }
}
