import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int ddeok = Integer.parseInt(st.nextToken());

        int dp[][] = new int[day+1][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 0;
        dp[2][1] = 1;

        for (int i = 3; i <= day; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        int a = dp[day][0];
        int b = dp[day][1];
        int x = 1;
        int y = 1;

        while(true){
            y = 1;
            while(true){
                if(x*a+y*b==ddeok){
                    System.out.println(x);
                    System.out.println(y);
                    return;
                }
                if(x*a+y*b> ddeok){
                    break;
                }
                y+=1;
            }
            x+=1;
        }
    }
}