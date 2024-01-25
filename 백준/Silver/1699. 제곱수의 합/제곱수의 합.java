import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int flag = 1;
        dp[0] = 0;


        for (int i = 1; i < n+1; i++) {

            if(i == flag*flag){
                dp[i] = 1;
                flag++;
            }else {
                dp[i] = i;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(dp[i],dp[j]+dp[i-j]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
