import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int total[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        total[0] = arr[0];
        long total2 = arr[0];

        for (int i = 1; i < n; i++) {
            total[i] += total[i - 1] + arr[i];
            total2 += total[i];
        }

        System.out.println(total2);
    }
}