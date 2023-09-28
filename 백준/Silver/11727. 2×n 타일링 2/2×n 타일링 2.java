import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n];

        dp[0]=1;
        if(n>1){
            dp[1]=3;
        }

        for (int i = 2; i < n; i++) {
            dp[i]= (dp[i-1]+2*dp[i-2])%10007;
        }

        System.out.println(dp[n-1]%10007);
    }
}