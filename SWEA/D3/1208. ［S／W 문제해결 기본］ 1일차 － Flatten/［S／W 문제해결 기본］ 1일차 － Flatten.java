
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dump = Integer.parseInt(br.readLine());
            int arr[] = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for( int i = 0; i <dump ; i++){
                arr[0] = arr[0]+ 1;
                arr[99] = arr[99]-1;
                Arrays.sort(arr);
            }


            System.out.println("#" + test_case + " " +(arr[99]-arr[0]));
        }
    }

}