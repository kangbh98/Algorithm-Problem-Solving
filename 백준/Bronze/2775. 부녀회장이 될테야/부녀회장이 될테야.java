import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[15][15];

        for (int i = 0; i < 15; i++) {
            arr[0][i] = i + 1;
            arr[i][0] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int k = 1; k < 15; k++) {
                arr[i][k]= arr[i-1][k]+arr[i][k-1];
            }
        }

        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(br.readLine());
            int num2  = Integer.parseInt(br.readLine());
            System.out.println(arr[num1][num2-1]);
        }
    }
}
