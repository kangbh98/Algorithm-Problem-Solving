import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int board[][];
    public static boolean visited[][];
    public static int n,m;
    public static boolean flag = false;
    public static int count = 0;
    public static int plusX[] = {1,1,1,0,0,-1,-1,-1};
    public static int plusY[] = {-1,0,1,-1,1,-1,0,1};


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                // 방문안했으면 봉우리 탐색
                if (!visited[i][j]) {
                    flag = true;
                    bfs(i, j);
                    if (flag) {

                        count++;
//                        for (int a = 1; a < n + 1; a++) {
//                            for (int b = 1; b < m + 1; b++) {
//                                System.out.print(visited[a][b] + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println("--------------------------");
                    }

                }
            }
        }

    System.out.println(count);
    }

    public static void bfs(int x1,int y1){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x1,y1));

        while (!queue.isEmpty()){

            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            visited[x][y] = true;

            for(int i = 0 ; i < 8 ; i++){

                int xd = x+plusX[i];
                int yd = y+plusY[i];

                if(xd > 0 && yd > 0 && xd < n+1 && yd < m+1){

                    if(board[xd][yd] == board[x][y] && !visited[xd][yd]){
                        queue.add(new Node(xd,yd));
                    }else if(board[xd][yd] > board[x][y]){
                        flag = false;
                    }

                }
            }

        }

    }
}