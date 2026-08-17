public class Solution {
    public IList<string> SummaryRanges(int[] arr) {
        int n=arr.Length;
        IList<string> l=new List<string>();
        int i=0;
        while(i<n){
            string s=arr[i]+"";
            int j=i;
            while(j+1<n && arr[j+1]==arr[j]+1) j++;
            if(i==j){
                l.Add(s);
                i++;
            }
            else{
                s+="->";
                s+=arr[j];
                l.Add(s);
                i=j+1;
            }
        }
        return l;
    }
}
