import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{



    static int r;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 첫번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];


        // 배열 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 r 번 실시
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int calNum = Integer.parseInt(st.nextToken());
            if(calNum==1){      //완
                arr = cal1(arr);
            }else if(calNum==2){//완
                arr = cal2(arr);
            }else if(calNum==3){ //완
                arr =cal3(arr);
            }else if(calNum==4){ //완
                arr =cal4(arr);
            }else if(calNum==5){
                arr =cal5(arr);
            }else if(calNum==6){
                arr = cal6(arr);
            }
        }
        extracted(arr);

    }

    private static void extracted(int[][] arr) {
        for (int[] k: arr){
            for(int x :k){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    public static int[][] cal1(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int arr2[][] = new int[n][m];

        int x = 0;
        int y = 0;

        for (int i = n-1; i > -1; i--) {
            for (int j = 0; j < m; j++) {
                arr2[x][y]= arr[i][j];
                y++;
            }
            y=0;
            x++;
        }
        return arr2;
    }
    public static int[][] cal2(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int arr2[][] = new int[n][m];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m-1; j > -1; j--) {
                arr2[x][y]= arr[i][j];
                y++;
            }
            y=0;
            x++;
        }
        return arr2;
    }
    public static int[][] cal3(int arr[][]){
        int n = arr[0].length;
        int m = arr.length;

        int arr2[][] = new int[n][m];

        int x = 0;
        int y = 0;

        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i > -1; i--) {
                arr2[x][y]= arr[i][j];
                y++;
            }
            y=0;
            x++;
        }
        return arr2;
    }
    public static int[][] cal4(int arr[][]){
        int n = arr[0].length;
        int m = arr.length;

        int arr2[][] = new int[n][m];

        int x = 0;
        int y = 0;

        for (int j = n-1; j > -1; j--) {
            for (int i = 0; i < m; i++) {
                arr2[x][y]= arr[i][j];
                y++;
            }
            y=0;
            x++;
        }
        return arr2;
    }

    public static int[][] cal5(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int arr2[][] = new int[n][m];

        int x_mid = n/2;
        int y_mid = m/2;

        for (int i = 0; i < x_mid; i++) {
            for (int j = 0; j < y_mid; j++) {
                arr2[i][j +y_mid] = arr[i][j];
            }
        }

        for (int i = 0; i < x_mid; i++) {
            for (int j = y_mid; j < m; j++) {
                arr2[i+x_mid][j] = arr[i][j];
            }
        }

        for (int i = x_mid; i < n; i++) {
            for (int j = y_mid; j < m; j++) {
                arr2[i][j-y_mid] = arr[i][j];
            }
        }

        for (int i = x_mid; i < n; i++) {
            for (int j = 0; j < y_mid; j++) {
                arr2[i-x_mid][j] = arr[i][j];
            }
        }
        return arr2;
    }
    public static int[][] cal6(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int arr2[][] = new int[n][m];

        int x_mid = n/2;
        int y_mid = m/2;

        for (int i = 0; i < x_mid; i++) {
            for (int j = 0; j < y_mid; j++) {
                arr2[i+x_mid][j] = arr[i][j];
            }
        }

        for (int i = 0; i < x_mid; i++) {
            for (int j = y_mid; j < m; j++) {
                arr2[i][j-y_mid] = arr[i][j];
            }
        }

        for (int i = x_mid; i < n; i++) {
            for (int j = y_mid; j < m; j++) {
                arr2[i-x_mid][j] = arr[i][j];
            }
        }

        for (int i = x_mid; i < n; i++) {
            for (int j = 0; j < y_mid; j++) {
                arr2[i][j+y_mid] = arr[i][j];
            }
        }
        return arr2;
    }
}

