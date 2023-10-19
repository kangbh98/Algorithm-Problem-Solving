import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static int n;
    public static int count=0;
    public static int m;
    public static int d;
    public static int arr[][];
    public static boolean tf[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken())+1;
        int j = Integer.parseInt(st.nextToken())+1;
        d = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        tf = new boolean[n+1][m+1];


        for (int a = 1; a <= n; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 1; b <= m; b++) {
                arr[a][b] = Integer.parseInt(st.nextToken());
            }
        }
        Cal(i,j);
    }

    public static void Cal(int i , int j){

        if(!tf[i][j]){
            tf[i][j]=true;
            count++;
        }
        boolean no_blank = true; // 주위에 청소되지 않은 빈칸이 없다. : 시작 true

        int arr1[] = {0, 0, -1, 1};
        int arr2[] = {-1, 1, 0, 0};

        for (int a = 0; a < 4; a++) {
            int x = i + arr1[a];
            int y = j + arr2[a];

            if( (x>0&&x<=n) && (y>0 && y<=m) &&
                    !tf[x][y] && arr[x][y]==0
            ){
                no_blank = false;
                break;
            }
        }
        if(no_blank == true){
            // 뒤로 가는거
            Cal2(i,j);
        }else {
            // 반시계 방향으로 회전하고 앞쪽칸 청소되지 않았으면 전진
            Cal3(i,j);
        }
    }

    public static void Cal2(int i, int j) {

        if (d == 0 &&  i+1<=n && arr[i+1][j]==0 ) {
            Cal(i+1,j);
        }else if(d == 1 && j-1>0 && arr[i][j-1]==0) {
            Cal(i,j-1);
        }else if(d == 2 && i-1>0 && arr[i-1][j]==0) {
            Cal(i-1,j);
        }else if(d== 3&& j+1<=m && arr[i][j+1]==0 ){
            Cal(i,j+1);
        }else {
            System.out.println(count);
            return;
        }
    }

    public static void Cal3(int i, int j) {

        while (true){
            d--;
            if(d<0) d+=4;

            if (d == 0 &&  i-1>0 && !tf[i-1][j] && arr[i-1][j]==0 ) {
                Cal(i-1,j);
                break;
            }else if(d == 1 && j+1<=m && arr[i][j+1]==0 && !tf[i][j+1]) {
                Cal(i,j+1);
                break;
            }else if(d == 2 && i+1<=n && arr[i+1][j]==0 && !tf[i+1][j]) {
                Cal(i+1,j);
                break;
            }else if(d== 3&& j-1>0 && arr[i][j-1]==0 && !tf[i][j-1]){
                Cal(i,j-1);
                break;
            }

        }
    }
}