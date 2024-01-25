import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        long total = dp[0];

        for (int i = 1; i < n; i++) {

            total = Math.max(total + arr[i],arr[i]);
            dp[i] = Math.max(dp[i - 1], total);
            
        }
        System.out.println(dp[n - 1]);
    }
}