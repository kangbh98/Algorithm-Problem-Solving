import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static int n;
    static int m;
    static int arr[][];
    static int arr2[][];
    static int cctvCount=0;
    static int 사각지대최소크기=Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        arr2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
                arr2[i][j] = arr[i][j];

                if (arr[i][j] > 0 && arr[i][j] != 6) {
                    cctvCount++;
                }
            }
        }

        int cctvDirection[] = new int[cctvCount];
        int depth = 0;
        recursion(cctvDirection, depth);
        System.out.println(사각지대최소크기);
    }

    public static void recursion(int[] cctvDirection,int depth) {

        if (depth == cctvCount) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = arr2[i][j];
                }
            }
            bfs(cctvDirection);
            return;
        }

        cctvDirection[depth] = 1;
        recursion(cctvDirection,depth+1);
        cctvDirection[depth] = 2;
        recursion(cctvDirection,depth+1);
        cctvDirection[depth] = 3;
        recursion(cctvDirection,depth+1);
        cctvDirection[depth] = 4;
        recursion(cctvDirection,depth+1);

    }

    public static void bfs(int[] cctvDirection) {


//        System.out.println(cctvCount);
//        System.out.println("-------------");
//        for(int i : cctvDirection){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        System.out.println("-------------");

        int d = 0 ;
        for (int i = 0; i < n; i++) {

            if(d>=cctvCount){
                break;
            }

            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 1 && cctvDirection[d]==1) {
                    d++;
                    // 오른쪽
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;
                        arr[i][a] = -1;
                    }
                }else if (arr[i][j] == 1 && cctvDirection[d]==2) {
                    d++;
                    // 위
                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                }else if (arr[i][j] == 1 && cctvDirection[d]==3) {
                    d++;
                    // 왼쪽
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }else if (arr[i][j] == 1 && cctvDirection[d]==4) {
                    d++;
                    //아래
                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                }else if (arr[i][j] == 2 && (cctvDirection[d]==1 || cctvDirection[d]==3)) {
                    d++;
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }else if (arr[i][j] == 2 && (cctvDirection[d]==2 || cctvDirection[d]==4)) {
                    d++;
                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }

                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                }else if(arr[i][j] == 3 && cctvDirection[d]==1){
                    d++;
                    //위 오른
                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }else if(arr[i][j] == 3 && cctvDirection[d]==2){
                    d++;
                    // 왼 위
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                }else if(arr[i][j] == 3 && cctvDirection[d]==3){
                    d++;
                    // 왼 아래
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                }else if(arr[i][j] == 3 && cctvDirection[d]==4){
                    d++;
                    // 아래 오른
                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }else if(arr[i][j] == 4 && cctvDirection[d]==1){
                    d++;
                    // 왼 위 오른
                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }else if(arr[i][j] == 4 && cctvDirection[d]==2){
                    d++;
                    // 왼 위 아래
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                }else if(arr[i][j] == 4 && cctvDirection[d]==3){
                    d++;
                    // 왼 아래 오른

                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }else if(arr[i][j] == 4 && cctvDirection[d]==4){
                    d++;
                    //  위 아래 오른
                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }

                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }

                }else if(arr[i][j] == 5){
                    d++;
                    // 네방향
                    for (int a = i + 1; a < n; a++) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }

                    for (int a = i - 1; a > -1; a--) {
                        if(arr[a][j] == 6){
                            break;
                        }
                        if(arr[a][j]!=0) continue;

                        arr[a][j] = -1;
                    }
                    for (int a = j + 1; a < m; a++) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                    for (int a = j - 1; a > -1; a--) {
                        if(arr[i][a] == 6){
                            break;
                        }
                        if(arr[i][a]!=0) continue;

                        arr[i][a] = -1;
                    }
                }
            }
        }
        count();
    }
    public static void count(){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j]+" ");
                if(arr[i][j]==0){
                    count++;
                }
            }
//            System.out.println();
        }
//        System.out.println("끝끝끝");
//        System.out.println("끝끝끝");
        사각지대최소크기 = Math.min(사각지대최소크기, count);
    }

}