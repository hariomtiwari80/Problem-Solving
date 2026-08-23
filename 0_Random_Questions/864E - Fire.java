
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][4];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            arr[i][2]=sc.nextInt();
            arr[i][3]=i;
            sum+=arr[i][0];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        int[][] dp=new int[n+1][sum+1];
        for(int i=1;i<=n;i++){
            for(int t=0;t<=sum;t++){
                dp[i][t]=dp[i-1][t];
            }
            for(int t=0;t<=sum;t++){
                int newtime=t+arr[i-1][0];
                if(newtime<arr[i-1][1]){
                    dp[i][newtime]=Math.max(dp[i][newtime],dp[i-1][t]+arr[i-1][2]);
                }
            }
        }
        int maxidx=0,max=0;
        for(int t=0;t<=sum;t++){
            if(dp[n][t]>max){
                max=dp[n][t];
                maxidx=t;
            }
        }
        List<Integer> l=new ArrayList<>();
        for(int i=n;i>=1;i--){
            if(dp[i][maxidx]==dp[i-1][maxidx]) continue;
            else{
                l.add(arr[i-1][3]+1);
                maxidx-=arr[i-1][0];
            }
        }
        System.out.println(max);
        System.out.println(l.size());
        for(int i=l.size()-1;i>=0;i--){
            System.out.print(l.get(i)+" ");
        }
    }
}
