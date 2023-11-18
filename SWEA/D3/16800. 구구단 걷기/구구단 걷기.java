import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {

            long n = sc.nextLong();
            long count =1;
            long total = Long.MAX_VALUE;
            while (count < Math.sqrt(n)+1) {
                if (n % count == 0) {
                    total = Math.min(total,(count-1)+(n / count-1));

                }
                count++;
            }
            System.out.println("#"+test_case+" "+total);
        }
    }
}