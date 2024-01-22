import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    static int arr1[][];
    static int arr2[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr1= new int[n][m];
        arr2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr1[i][j] = s.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr2[i][j] = s.charAt(j)-'0';
            }
        }
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if(arr1[i][j]!=arr2[i][j]){
                    cal(i,j);
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr1[i][j]!=arr2[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    public static void cal(int i, int j) {

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                arr1[i+a][j+b] = arr1[i+a][j+b] ^ 1;
            }
        }
    }


}