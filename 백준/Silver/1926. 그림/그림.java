import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static int arr[][];
    public static boolean tf[][];
    public static int n;
    public static int m;
    public static int tf_count=0;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //가로 크기
        n = Integer.parseInt(st.nextToken()); // 세로 크키

        int count = 0;
        int max = 0; // 최대 그림의 넓이

        arr = new int[m][n];
        tf = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {

                if (arr[x][y] == 1 && !tf[x][y]) {

                    count++;
                    tf_count++;
                    dfs(x, y);

                    if(tf_count>max){
                        max=tf_count;
                    }
                }
                tf_count=0;
            }
        }
        System.out.println(count);
        System.out.println(max);

    }

    public static void dfs(int x, int y) {

        tf[x][y]=true;

        int dfs1[] = {0, 0, -1, 1};
        int dfs2[] = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {

            int xn = x + dfs1[i];
            int yn = y + dfs2[i];

            if ((xn > -1 && xn < m ) && (yn > -1 && yn < n) && arr[xn][yn]==1 && !tf[xn][yn]) {

                tf_count++;
                dfs(xn,yn);
            }

        }

    }
}