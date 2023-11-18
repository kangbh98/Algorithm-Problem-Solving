import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{


    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int count = 1;
            int arr[] = {0,1,0,-1};
            int arr2[] = {1,0,-1,0};
            int array[][] = new int[n][n];
            int x =0;
            int y= 0;
            int pick = 0;
            boolean visited[][]  = new boolean[n][n];

            while (count < n * n+1 ) {

                array[x][y] = count;
                visited[x][y] = true;
                x += arr[pick%4];
                y += arr2[pick%4];

                if (x < 0 || x > n - 1 || y < 0 || y > n - 1|| visited[x][y]) {
                    x -= arr[pick%4];
                    y -= arr2[pick%4];
                    pick +=1;
                    x += arr[pick%4];
                    y += arr2[pick%4];
                }
                count++;
            }


            System.out.println("#"+test_case+" ");
            for (int[] ints : array) {
                for (int anInt : ints) {
                    System.out.print(anInt+" ");
                }
                System.out.println();
            }
        }
    }


}