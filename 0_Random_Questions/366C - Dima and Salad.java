import java.util.*;
public class Main {
    public static int[][] dp;
    public static int offset=100000;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] taste=new int[n];
        int[] cal=new int[n];
        for(int i=0;i<n;i++){
            taste[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            cal[i]=sc.nextInt();
        }
        dp=new int[n+1][200000+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        int ans=find(taste,cal,0,0,k);
        if(ans==0) System.out.print(-1);
        else System.out.print(ans);
    }
    public static int find(int[] taste,int[] cal,int i,int diff,int k){
        if(i==taste.length){
            if(diff==0) return 0;
            else return Integer.MIN_VALUE/2;
        }
        if(dp[i][diff+offset]!=-1) return dp[i][diff+offset];
        int skip=find(taste,cal,i+1,diff,k);
        int take=taste[i]+find(taste,cal,i+1,diff+taste[i]-k*cal[i],k);
        int ans=Math.max(take,skip);
        return dp[i][diff+offset]=ans;
    }
}
