import java.io.*;
import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long arr[][] = new long[n+1][n+1];
        int inf = 100000000;


        for (int i = 1; i <= n; i++) { //i 는 경유 노드
            for (int k = 1; k <= n; k++) {
                if(i==k){
                    arr[i][k]=0;
                }else {
                    arr[i][k]=inf;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int charge = Integer.parseInt(st.nextToken());

            arr[x][y] = Math.min(arr[x][y],charge);

        }



        for (int i = 1; i <= n; i++) { //i 는 경유 노드
            for (int k = 1; k <= n; k++) { //k는 시작노드
                for (int j = 1; j <= n; j++) { //j는 끝노드
                    if (k!=j) {
                        arr[k][j] = Math.min(arr[k][j],arr[k][i]+arr[i][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) { //i 는 경유 노드
           for (int k = 1; k <= n; k++){
              if(arr[i][k]==inf) {
                   sb.append(0 + " ");
             } else {
                   sb.append(arr[i][k]+" ");
               }
           }
           sb.append("\n");
        }
        System.out.println(sb);
    }
}