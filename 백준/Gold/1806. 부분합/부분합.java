import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        long plus = 0;
        int min_length = Integer.MAX_VALUE;

        do {
            if (plus < s) {
                if (end >= n){
                    break;
                }
                plus += arr[end];
                end++;
            } else if (plus >= s) {
                if (start>=n){
                    break;
                }
                plus -= arr[start];
                start++;

                int num = end - start + 1;
                if(num < min_length){
                    min_length = num;
                }
            }
        } while (true);
        if (min_length == Integer.MAX_VALUE){
            System.out.println(0);
        }else {
            System.out.println(min_length);
        }
   
    }
}