import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = b-a;
            if (c ==1) {
                System.out.println("#" + test_case + " " + -1);
            }else if(c<0){
                System.out.println("#" + test_case + " " + -1);
            }else {
                System.out.println("#" + test_case + " " + c / 2);
            }
        }
    }
}