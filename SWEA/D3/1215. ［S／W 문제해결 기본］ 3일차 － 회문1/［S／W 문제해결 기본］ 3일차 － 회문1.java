import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{

    static int move1[] = {0, 0, -1, 1};
    static int move2[] = {-1, 1, 0, 0};
    static char arr[][] = new char[8][8];
    static int n;
    static int total;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    imple(i, j);
                }
            }
            System.out.println("#"+test_case+" "+total/2);
            total =0;
        }
    }

    static void imple(int x, int y) {

        for (int a = 0; a < 4; a++) {

            String str = ""+arr[x][y];

            for (int i = 0; i < n-1; i++) {
                int x2 = x + move1[a]*(i+1);
                int y2 = y + move2[a]*(i+1);

                if (x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
                    break;
                }

                str = str + arr[x2][y2];
                if(str.length()==n && verify(str)){
                    total++;
                    str="";
                }
            }
        }
    }

    static boolean verify(String str){

        int end = n-1;
        int start = 0;
        while (start<end){

            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}