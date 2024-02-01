import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t_case = 1; t_case <= T; t_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int arr[][] = new int[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
            int total = -1;
            for (int i = m ; i <= n; i++) {
                for (int j = m; j <= n; j++) {
                    total = Math.max(total,arr[i][j] - arr[i][j-m] - arr[i-m][j] + arr[i - m][j - m]);
                }
            }

            System.out.println("#"+t_case+" "+total);

        }
    }
}

