import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int arr[][] = new int[100][100];
            StringTokenizer str;
            String k = br.readLine();
            int 행의합[] = new int[100];
            int 열의합[] = new int[100];

            for (int i = 0; i < 100; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                    행의합[i] += arr[i][j];
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    열의합[i] += arr[j][i];
                }
            }

            int max_행의합 = 0;
            int max_열의합 =0;
            int 아래대각선 =0;
            int 위대각선 = 0;
            int total = 0;

            for (int i = 0; i < 100; i++) {
                if (행의합[i] > max_행의합) {
                    max_행의합 = 행의합[i];
                }
                if (열의합[i] > max_열의합) {
                    max_열의합 = 열의합[i];
                }
            }
            int j=99;
            for (int i = 0; i < 100; i++) {
                아래대각선+=arr[i][i];
                위대각선+=arr[i][j];
                j--;
            }
            total= Math.max(위대각선,Math.max(아래대각선,Math.max(max_열의합,max_행의합)));
            System.out.println("#"+test_case+" "+total);

        }
    }
}