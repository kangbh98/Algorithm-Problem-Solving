import java.io.*;
import java.lang.*;

public class Main{


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        long dp[][] = new long[10][1001];
        for (int i = 0; i < 10; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i < 1001; i++) {
            dp[0][i] += dp[7][i - 1];
            dp[1][i] += dp[4][i - 1] + dp[2][i - 1];
            dp[2][i] += dp[1][i - 1] + dp[5][i - 1] + dp[3][i - 1];
            dp[3][i] += dp[2][i - 1] + dp[6][i - 1];
            dp[4][i] += dp[1][i - 1] + dp[5][i - 1] + dp[7][i - 1];
            dp[5][i] += dp[2][i - 1] + dp[4][i - 1] + dp[6][i - 1]+ dp[8][i - 1];
            dp[6][i] += dp[3][i - 1] + dp[5][i - 1] + dp[9][i - 1];
            dp[7][i] += dp[4][i - 1] + dp[8][i - 1] + dp[0][i - 1];
            dp[8][i] += dp[7][i - 1] + dp[5][i - 1] + dp[9][i - 1];
            dp[9][i] += dp[6][i - 1] + dp[8][i - 1];

            for (int j = 0; j < 10; j++) {
                dp[j][i] %= 1234567;
            }
        }



        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());
            long total = 0;
            for (int i = 0; i < 10; i++) {
                total += dp[i][n];
            }
            System.out.println(total%1234567);
        }
    }


}