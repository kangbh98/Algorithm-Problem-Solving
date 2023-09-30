import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static int n;
    public static int m;
    public static int count = 0;
    public static int arr[][];
    public static boolean tf[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        tf = new boolean[n][m];
        int arr2[][] = new int[n][m];
        int min = m*n+1;
        int 기둥개수 = 3;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                int parsedInt = Integer.parseInt(st.nextToken());
                arr[i][k]= parsedInt;
                arr2[i][k]= parsedInt;
                if(arr[i][k]==1){
                    기둥개수++;
                }
            }
        }


        for( int i = 0 ; i < n*m-2 ; i++){
            for (int k = i+1; k < n * m - 1; k++) {
                for (int j = k+1; j < n * m; j++) {

                if(arr[i/m][i%m]==0 && arr[k/m][k%m]==0 && arr[j/m][j%m]==0){
                        arr[i/m][i%m]=1;
                        arr[k/m][k%m]=1;
                        arr[j/m][j%m]=1;

                        Cal();

                        if(count < min){
                            min = count;
                        }

                        count = 0;
                        tf = new boolean[n][m];
                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < m; b++) {
                                arr[a][b]= arr2[a][b];
                            }
                        }

                    }
                }
            }
        }
        System.out.println(n*m -min-기둥개수);
    }

    public static void Cal(){

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if(arr[i][k]==2 && !tf[i][k]){
                    Cal2(i,k);
                }
            }
        }
    }

    public static void Cal2(int i , int k) {


        arr[i][k] = 2;
        count++;
        tf[i][k]=true;

        int arrCal2[] = {0, 0, -1, 1};
        int arrCal22[] = {1, -1, 0, 0};

        for (int a = 0; a < 4; a++) {
            int i1 = i + arrCal2[a];
            int i2 = k + arrCal22[a];
            if((i1>-1 && i1<n) && (i2>-1 && i2 < m) && arr[i1][i2]!=1 && !tf[i1][i2]){
                Cal2(i1,i2);
            }
        }
    }
}