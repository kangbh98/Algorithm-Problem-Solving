import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean arr[][] = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int k = 1; k <= 10; k++) {
                for (int z = 1; z <= 10; z++) {
                    arr[x + k][y+z] = true;
                    arr[x+z][y + k] = true;
                }
            }
        }
        int count  = 0;

        for (int i = 1; i < 101; i++) {
            for (int k = 1; k < 101; k++) {
                if(arr[i][k]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}