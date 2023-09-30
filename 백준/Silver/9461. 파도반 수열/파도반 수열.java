import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[101];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            Cal(k,arr);
        }
    }
    public static void Cal(int k,long arr[]){
        for (int i = 5; i < k; i++) {
            arr[i]=arr[i-1]+arr[i-5];
        }
        System.out.println(arr[k-1]);
    }
}