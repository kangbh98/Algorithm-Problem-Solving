import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    static int n;
    static int arr[][];

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;


        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int total=0;

            for (int j = 0; j < n; j++) {
                교착(j);
            }
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n-1; i++) {
                    if(arr[i][j] == 1 &&arr[i+1][j]==2){
                        total++;
                    }
                }
            }

            System.out.println("#" + test_case + " "+total);

        }
    }

    static void 교착(int Int) {
        for (int i = 0; i < n; i++) {
            if (i + 1 == n){
                if (arr[i][Int]==1) arr[i][Int]=0;
            } else if (arr[i][Int] == 1 && arr[i + 1][Int] == 0) {
                arr[i][Int] = 0;
                arr[i + 1][Int] = 1;

            }
        }
    }
}