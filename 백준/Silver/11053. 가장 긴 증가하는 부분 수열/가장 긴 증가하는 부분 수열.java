import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= in.nextInt();
        }
        for(int k=0;k<n;k++){
            dp[k]=1;
            for(int j=0;j<k;j++){
                if(arr[j]<arr[k]){
                    dp[k]=Math.max(dp[k],1+dp[j]);
                }
            }
        }
        int ans = 0;
        for(int z=0;z<n;z++){
            ans=Math.max(ans,dp[z]);
        }
        System.out.println(ans);
    }
}