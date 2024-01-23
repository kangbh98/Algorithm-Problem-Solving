import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {

    static int ans;
    static int arr[];
    static int n;
    static int count=0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int end = Integer.parseInt(st.nextToken());

        long dp[][] =new long[21][n - 1];
        dp[arr[0]][0] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 21; j++) {
               if(dp[j][i-1]!=0){

                   if(j+arr[i]<21){
                       dp[j + arr[i]][i] = dp[j + arr[i]][i] + dp[j][i - 1];
                   }
                   if(j-arr[i]>-1){
                       dp[j - arr[i]][i] = dp[j - arr[i]][i] + dp[j][i - 1];
                   }

               }
            }
        }

        System.out.println(dp[end][n-2]);
    }
}
