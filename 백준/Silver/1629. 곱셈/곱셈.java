import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static long c;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long num =Cal(a,b);
        System.out.println(num);
    }

    public static long Cal(long a,long b){
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long res = Cal(a,b/2);
            return res * res % c;
        }else {
            return Cal(a,b-1)* a%c;
        }
    }
}