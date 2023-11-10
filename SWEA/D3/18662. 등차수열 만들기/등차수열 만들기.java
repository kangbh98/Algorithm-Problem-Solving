import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            double a = (double) sc.nextInt();
            double b = (double)sc.nextInt();
            double c = (double)sc.nextInt();
            double answer1 = Math.abs( b - (a+c)/2);
            double answer2 = Math.abs(a+c-2*b);
            if (answer1<answer2) {
                System.out.println("#"+test_case+" "+answer1);
            }else {
                System.out.println("#"+test_case+" "+answer2);
            }
        }
    }
}