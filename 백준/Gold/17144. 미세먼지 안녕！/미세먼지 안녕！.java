import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static int r,c,t;
    static int map[][];
    static int plusX[] = {-1, 1, 0, 0};
    static int plusY[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        // 방 정보 입력
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 시간초 카운팅
        while(t-- > 0){
            // 미세먼지 확산
            확산();
            // 공기청정기 바람불기
            바람불기();
//            for (int i1 = 0; i1 < r; i1++) {
//                for (int j1 = 0; j1 < c; j1++) {
//                    System.out.print(map[i1][j1]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("========");
        }

        //미세먼지 양 출력
        미세먼지양출력();
    }

    public static void 확산(){

       int 확산map[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]>0){
                    int 빼는값 = map[i][j] / 5;
                    for (int a = 0; a < 4; a++) {

                        int x = i +plusX[a];
                        int y = j +plusY[a];

                        if(x > -1 && y >-1 && x < r && y < c && map[x][y] != -1){
                            map[i][j] -= 빼는값;
                            확산map[x][y] += 빼는값;
                        }
                    }
                    확산map[i][j] += map[i][j];

                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (map[i][j] == -1) continue;
                map[i][j] = 확산map[i][j];
            }
        }
    }
    public static void 바람불기(){
        int 공기청정방향1 = -1;
        int 공기청정방향2 = -1;
        for (int i = 0; i < r; i++) {
            if (map[i][0] == -1) {
                공기청정방향1 = i;
                공기청정방향2 = i + 1;
                break;
            }
        }
        위쪽바람불기(공기청정방향1);
        아래쪽바람불기(공기청정방향2);

//        for (int i1 = 0; i1 < r; i1++) {
//            for (int j1 = 0; j1 < c; j1++) {
//                System.out.print(map[i1][j1]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("========");
    }

    public static void 위쪽바람불기(int start){

        int 확산map[][] = new int[r][c];

        // 오른쪽 밀기
        for (int j = 1; j < c - 1; j++) {
            확산map[start][j + 1] = map[start][j];
            map[start][j] =0;
        }
        // 위쪽 밀기
        for (int i = start ; i > 0; i--) {
            확산map[i-1][c-1] = map[i][c-1];
            map[i][c-1] =0;
        }
        // 왼쪽 밀기
        for (int j = c-1 ; j > 0; j--) {
            확산map[0][j-1] = map[0][j];
            map[0][j] =0;
        }
        // 아래쪽 밀기
        for (int i = 0 ; i < start; i++) {
            확산map[i+1][0] = map[i][0] ;
            map[i][0] = 0;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == -1) continue;
                if(확산map[i][j]!=0){
                    map[i][j] = 확산map[i][j];
                }
            }
        }

    }
    public static void 아래쪽바람불기(int start){

        int 확산map[][] = new int[r][c];

        // 오른쪽 밀기
        for (int j = 1; j < c - 1; j++) {
            확산map[start][j + 1] = map[start][j];
            map[start][j] =0;
        }

        // 아래쪽 밀기
        for (int i = start ; i < r -1; i++) {
            확산map[i+1][c-1] = map[i][c-1] ;
            map[i][c-1] = 0;
        }

        // 왼쪽 밀기
        for (int j = c-1 ; j > 0; j--) {
            확산map[r-1][j-1] = map[r-1][j];
            map[r-1][j] =0;
        }

        // 위쪽 밀기
        for (int i = r-1 ; i > start; i--) {
            확산map[i-1][0] = map[i][0];
            map[i][0] = 0;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == -1) continue;
                if(확산map[i][j]!=0){
                    map[i][j] = 확산map[i][j];
                }
            }
        }

    }
    public static void 미세먼지양출력(){
        int Total = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Total += map[i][j];
            }
        }
        System.out.println(Total + 2);
    }
}