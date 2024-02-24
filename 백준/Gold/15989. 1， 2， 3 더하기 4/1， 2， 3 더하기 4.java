import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{


    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
          int n = Integer.parseInt(br.readLine());
          
          if(n==1){
              System.out.println(1);
              continue;
          } else if (n==2) {
              System.out.println(2);
              continue;
          }

          int dp[][] = new int[4][n + 1];
          dp[1][1] = 1;
          dp[1][2] = 1;
          dp[2][2] = 1;
          dp[1][3] = 2;
          dp[3][3] = 1;

            for (int i = 4; i < n + 1; i++) {
                dp[1][i] = dp[1][i - 1] + dp[2][i - 1] + dp[3][i - 1];
                dp[2][i] = dp[2][i - 2] + dp[3][i - 2];
                dp[3][i] = dp[3][i - 3];
            }

            System.out.println(dp[1][n]+dp[2][n]+dp[3][n]);
        }
    }
}