import java.io.*;
import java.lang.*;

public class Main{

    static int n;
    static int arr[];


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];

            for (int a = 1; a <= n; a++) {
                arr[a] = a;
            }

            recursion(1, "1", 1,0,1);
            System.out.println();
        }

    }

    public static void recursion(int depth,String str,long num,int 최근연산자,int 최근연산값) {

        if(depth==n){
            if (num == 0) {
                System.out.println(str);
            }
            return;
        }

        if(최근연산자==0){
            int num2 = 최근연산값 * 10 + arr[depth + 1];
            recursion(depth + 1, str + " " + arr[depth + 1], num-최근연산값+num2, 0, num2);
        } else if (최근연산자 == 1) {
            int num2 = 최근연산값 * 10 + arr[depth + 1];
            recursion(depth + 1, str + " " + arr[depth + 1], num+최근연산값-num2, 1, num2);
        }

        recursion(depth+1,str+"+"+arr[depth+1],num+arr[depth+1],0,arr[depth+1]);
        recursion(depth+1,str+"-"+arr[depth+1],num-arr[depth+1],1,arr[depth+1]);

    }
}