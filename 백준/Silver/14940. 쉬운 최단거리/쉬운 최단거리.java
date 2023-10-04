import java.io.*;
import java.util.*;
import java.lang.*;

class target{
    int x;
    int y;

    public target(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n;
    public static int m;
    public static int[][] arr;
    public static boolean[][] tf;
    public static Queue<target> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         queue = new LinkedList<>();
         arr = new int[n+1][m+1];
         tf = new boolean[n+1][m+1];

        for( int i = 1 ; i <= n ; i++){

            st = new StringTokenizer(br.readLine());
            for ( int k = 1; k <= m ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k]==2){
                     queue.add(new target(i,k));
                     arr[i][k]=0;
                }
            }
        }

        Cal();

        for( int i = 1 ; i <= n ; i++){
            for ( int k = 1; k <= m ; k++){
                if(!tf[i][k] && arr[i][k]==1) {
                    sb.append(-1).append(" ");
                }else{
                    sb.append(arr[i][k]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void Cal(){

        int[] arr1 = {0, 0, 1, -1};
        int[] arr2 = {-1, 1, 0, 0};

        while(!queue.isEmpty()){
            target t = queue.remove();

            int x = t.x;
            int y = t.y;

            for( int i = 0 ; i < 4 ; i++){
                int nx = x + arr1[i];
                int ny = y + arr2[i];

                if( (0<nx && nx<=n) && (0<ny && ny<=m) && arr[nx][ny]==1 && !tf[nx][ny]){
                    queue.add(new target(nx,ny));
                    tf[nx][ny]=true;
                    arr[nx][ny] = arr[x][y]+1;
                }

            }
        }
    }
}