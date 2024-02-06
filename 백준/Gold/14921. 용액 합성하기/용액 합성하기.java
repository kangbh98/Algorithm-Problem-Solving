import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = n-1;
        long total = 0;
        long ans = Integer.MAX_VALUE;

        while (start < end) {

            total = arr[start] + arr[end];

            if(Math.abs(total)<Math.abs(ans)){
                ans = total;
            }


            if(total < 0){
                start++;
            }else if(total>0){
                end--;
            }else {
                break;
            }
        }

        System.out.println(ans);
    }
}