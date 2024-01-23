import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int num1 = 0;
        int num2 = n-1;
        int ans = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;

        while(num1<num2){

            int i = arr[num1] + arr[num2];

            if(Math.abs(i) < ans){
                left =num1;
                right = num2;
                ans = Math.abs(i);
            }

            if(i>0){
                num2--;
            }else if(i<=0){
                num1++;
            }
        }

        System.out.println(arr[left] + " " + arr[right]);

    }
}
