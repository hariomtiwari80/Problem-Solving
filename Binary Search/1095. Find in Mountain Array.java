/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int t, MountainArray arr) {
        int pid=peakIndex(arr);
        int ans1=find1(arr,pid,t);
        if(ans1!=-1) return ans1;
        int ans2=find2(arr,pid,t);
        if(ans2!=-1) return ans2;
        return -1;
    }
    public int peakIndex(MountainArray arr){
        int l=0,h=arr.length()-1;
        while(l<h){
            int m=l+(h-l)/2;
            if(arr.get(m)>arr.get(m+1)) h=m;
            else l=m+1;
        }
        return l;
    }
    public int find1(MountainArray arr,int lastIdx,int t){
        int l=0,h=lastIdx;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr.get(m)==t) return m;
            else if(arr.get(m)>t) h=m-1;
            else l=m+1;
        }
        return -1;
    }
    public int find2(MountainArray arr,int lastIdx,int t){
        int l=lastIdx,h=arr.length()-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr.get(m)==t) return m;
            else if(arr.get(m)>t) l=m+1;
            else h=m-1;
        }
        return -1;
    }
}
