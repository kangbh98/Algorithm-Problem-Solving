import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution
{


    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = br.readLine();
            char initial = '0';
            int total = 0;

            for (int i = 0; i < str.length(); i++) {

                if (initial != str.charAt(i)) {
                    total++;
                    initial = str.charAt(i);
                }
            }
            System.out.println("#"+test_case+" "+total);
        }
    }


}