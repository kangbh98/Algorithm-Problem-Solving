import java.io.*;
import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] =new int[26];


        int input;
        for ( int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for (int k = 0; k < str.length(); k++) {
                input = str.charAt(k)-'A';
                double pow = Math.pow(10, str.length() - k-1);
                arr[input] += (int) pow;
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int total = 0;
        for( int i = 25 ; i > 15 ; i--){
            total += arr[i]*num;
            num--;
        }
        System.out.println(total);
    }
}