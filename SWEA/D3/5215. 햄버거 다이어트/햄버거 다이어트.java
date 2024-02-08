import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class Solution
{


    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());



        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] ham = new int[n+1][3];
            int[][] dp = new int[n+1][l+1];

            for (int i = 1; i < n+1; i++) {
                st = new StringTokenizer(br.readLine());
                ham[i][1] = Integer.parseInt(st.nextToken());
                ham[i][2] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ham,new Comparator<int[]>(){
               @Override
               public int compare(int[] o1,int[] o2){
                   return o1[2]-o2[2];
               }
            });

//            for(int[] a:ham){
//                for(int b : a){
//                    System.out.print(b+" ");
//                }
//                System.out.println();
//            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < l + 1; j++) {

                    if(j<ham[i][2]){
                        dp[i][j] = dp[i-1][j];
                    }else {

                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-ham[i][2]]+ham[i][1]);
                    }
                }
            }

//            for(int[] a:dp){
//                for(int b : a){
//                    System.out.print(b+" ");
//                }
//                System.out.println();
//            }


            System.out.println("#"+test_case+" "+dp[n][l]);
        }

    }

}