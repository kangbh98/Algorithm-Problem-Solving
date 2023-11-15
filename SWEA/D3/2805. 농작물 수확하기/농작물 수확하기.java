
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{


    static int n;
    static boolean arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
           int n = Integer.parseInt(br.readLine());
           int arr[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j)-'0';
                }
            }

            int count = n/2; //2
            int total = 0;
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = count; j < n - count; j++) {
                    total+= arr[i][j];
                }
                count-=1;
            }
            count+=1;
            for (int i = n / 2 + 1; i < n; i++) {
                count+=1;
                for (int j = count; j < n - count; j++) {
                    total+= arr[i][j];
                }
            }

           System.out.println("#" + test_case + " " +total);
        }
    }

}