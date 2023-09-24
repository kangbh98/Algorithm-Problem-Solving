import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int arr[] = new int[n];
        long hashNum = 0;

        for (int i = 0; i < n; i++) {
           int a =str.charAt(i)-'a'+1;
           hashNum += a * ((int)Math.pow(31,i));
        }
        System.out.println(hashNum);
    }

}