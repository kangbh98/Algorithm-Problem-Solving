import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static int arr[][];
    public static boolean tf[][];
    public static int n;
    public static int m;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;

            arr =new int[m][n];
            tf = new boolean[m][n];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m ; x++){
                    if( arr[x][y]==1 && !tf[x][y]){
                        count++;
                        dfs(x, y);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {

        tf[x][y]=true;

        int dfs1[] = {0, 0, -1, 1};
        int dfs2[] = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {

            int xn = x + dfs1[i];
            int yn = y + dfs2[i];

            if ((xn > -1 && xn < m ) && (yn > -1 && yn < n) && arr[xn][yn]==1 && !tf[xn][yn]) {
                dfs(xn,yn);
            }

        }

    }
}