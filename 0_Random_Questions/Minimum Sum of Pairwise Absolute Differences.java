import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] first=new int[n/2];
        int[] last=new int[n/2];
        for(int i=0;i<n/2;i++){
            first[i]=sc.nextInt();
        }
        for(int i=0;i<n/2;i++){
            last[i]=sc.nextInt();
        }
        Arrays.sort(first);
        Arrays.sort(last);
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=Math.abs(first[i]-last[i]);
        }
        System.out.print(ans);
    }
}
