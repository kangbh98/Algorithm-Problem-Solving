import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n,l,r,연합갯수;
    static int map[][];
    static int visited[][];
    static int plusX[] = {-1,1,0,0};
    static int plusY[] = {0,0,-1,1};


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        while(true){

            visited = new int[n][n];
            연합갯수=1;

            cal1();

            if(연합갯수==n*n+1) break;
            else count++;
        }

        System.out.println(count);
    }

    public static void cal1(){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==0){
                    cal2(i,j);
                    연합갯수++;
                }
            }
        }

    }

    public static void cal2(int i , int j){

        int 총합 = map[i][j];
        int 갯수 = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));
        visited[i][j] = 연합갯수;

        while (!q.isEmpty()) {

            Node node = q.remove();

            for (int a = 0; a < 4; a++) {

                int x = node.x+plusX[a];
                int y = node.y+plusY[a];

                if (x > -1 && y > -1 && x < n && y < n) {
                    if(visited[x][y] == 0 && Math.abs(map[x][y]-map[node.x][node.y])>=l && Math.abs(map[x][y]-map[node.x][node.y])<=r) {
                        q.add(new Node(x, y));
                        visited[x][y] = 연합갯수;
                        총합 += map[x][y];
                        갯수 += 1;
//                        System.out.println(x+" "+y);
//                        System.out.println(총합);
//                        System.out.println(갯수);
                    }
                }
            }
        }

        cal3(총합/갯수);

//        for (int x = 0; x < n; x++) {
//            for (int z = 0; z < n; z++) {
//                    System.out.print(visited[x][z]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("===============================");
    }
    public static void cal3(int num){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==연합갯수){
                    map[i][j] = num;
                }
            }
        }
    }
}