import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static int n,m,x,y;
    static int 주사위[][] = new int[4][3];
    static int map[][];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1){
                if( y == m-1) continue;
                y++;
                calEast();
            }else if (num == 2){
                if( y  == 0) continue;
                y--;
                calWest();
            }else if (num == 3){
                if( x == 0) continue;
                x--;
                calNorth();
            }else if (num == 4 ){
                if( x == n-1) continue;
                x++;
                calSouth();
            }

//            System.out.println("=========="+i+"====");
//            for (int[] arr12 : 주사위) {
//                for(int as : arr12){
//                    System.out.print(as+" ");
//                }
//                System.out.println();
//            }
        }
    }

    public static void calEast(){

        int num = 주사위[1][0];
        주사위[1][0] = 주사위[3][1];
        주사위[3][1] = 주사위[1][2];
        주사위[1][2] = 주사위[1][1];
        주사위[1][1] = num;

        print();
    }

    public static void calWest(){

        int num = 주사위[1][0];
        주사위[1][0] = 주사위[1][1];
        주사위[1][1] = 주사위[1][2];
        주사위[1][2] = 주사위[3][1];
        주사위[3][1] = num;
        print();
    }
    public static void calNorth(){

        int num = 주사위[0][1];
        주사위[0][1] = 주사위[1][1];
        주사위[1][1] = 주사위[2][1];
        주사위[2][1] = 주사위[3][1];
        주사위[3][1] = num;

        print();
    }
    public static void calSouth(){
        int num = 주사위[0][1];
        주사위[0][1] = 주사위[3][1];
        주사위[3][1] = 주사위[2][1];
        주사위[2][1] = 주사위[1][1];
        주사위[1][1] = num;

        print();
    }

    private static void print() {
        if(map[x][y]==0){
            map[x][y] = 주사위[3][1];
        }else if(map[x][y]!=0){
            주사위[3][1] = map[x][y];
            map[x][y] = 0;
        }
        System.out.println(주사위[1][1]);
    }

}