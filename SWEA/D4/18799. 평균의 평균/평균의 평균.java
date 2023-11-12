import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
       

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int arr[] = new int[n];
            long total = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                total += arr[i];
            }

            if(total%n==0){
                int average2 = (int) total/n;
                System.out.println("#"+test_case+" "+average2);
            }else {
                double average =(double) total/n;
                System.out.println("#"+test_case+" "+average);
            }
        }
    }
}