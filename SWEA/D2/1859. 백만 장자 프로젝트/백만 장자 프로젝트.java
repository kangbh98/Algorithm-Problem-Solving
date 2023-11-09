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
            int n = sc.nextInt();
            int arr[] = new int[n];
            for( int i = 0 ; i < n ; i++){
                arr[i]= sc.nextInt();
            }
            int pointer = arr[n-1];
            long total = 0;
            for( int i = n-2 ; i >-1; i--){
                if(arr[i]<pointer){
                    total = total + pointer-arr[i];
                }else {
                    pointer = arr[i];
                }
            }
            System.out.println("#"+test_case+" "+total);
        }
    }
}