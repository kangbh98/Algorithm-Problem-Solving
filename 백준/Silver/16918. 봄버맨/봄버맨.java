import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static int r;
    public static int c;
    public static boolean tf[][];
    public static int arr[][];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[r+1][c+1];


        for (int i = 1; i <= r; i++) {
            String str = br.readLine();
            for (int k = 1; k <= c; k++) {

                char c1 = str.charAt(k - 1);

                if(c1=='.'){
                    arr[i][k]=-1;
                } else{
                    arr[i][k]=2;
                }
            }
        }



        int second = 1;
        while(second<n){
            tf = new boolean[r+1][c+1];
            second++;

            for (int i = 1; i <= r; i++) {
                for (int k = 1; k <= c; k++) {

                    if(!tf[i][k]){
                        if(arr[i][k]==-1){
                            arr[i][k]=3;
                            tf[i][k] = true;
                        } else if (arr[i][k] == 1) {
                            arr[i][k]=-1;
                            tf[i][k]=true;
                            cal(i,k);
                        }else{
                            arr[i][k]--;
                            tf[i][k]=true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int k = 1; k <= c; k++) {
                if(arr[i][k]==-1){
                    System.out.print('.');
                }else {
                    System.out.print('O');
                }
            }
            System.out.println();
        }
    }

    public static void cal (int i, int k){
        int arr1[] = {0, 0, -1, 1};
        int arr2[] = {-1, 1, 0, 0};

        for (int a = 0; a < 4; a++) {
            int x = i + arr1[a];
            int y = k + arr2[a];

            if ((x > 0 && x <= r) && (y > 0 && y <= c)) {

                if( !tf[x][y] && arr[x][y]==1){
                   continue;
                }else {
                    arr[x][y]=-1;
                    tf[x][y]=true;
                }
            }
        }
    }

}