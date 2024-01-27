import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        boolean arr[] = new boolean[n+1];

        for (int t = 0; t < q; t++) {

            Integer x = Integer.parseInt(br.readLine());
            int end = x;
            int 점유오리 = Integer.MAX_VALUE;

            do {
                if(arr[x]){
                    점유오리 = x;
                }
                x /= 2;
            } while (x > 1);

            if(점유오리 == Integer.MAX_VALUE){
                arr[end] = true;
                System.out.println(0);
            }else{
                System.out.println(점유오리);
            }

        }
    }
}