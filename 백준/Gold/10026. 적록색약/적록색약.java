import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x  = x;
            this.y = y;
        }
    }

    static int plus_x[] = {-1, 1, 0, 0};
    static int plus_y[] = {0, 0, -1, 1};

    static char arr[][];
    static boolean visitedNormal[][];
    static boolean visitedDisable[][];
    static int n;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visitedNormal = new boolean[n][n];
        visitedDisable = new boolean[n][n];
        int normalCount = 0;
        int disableCount = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[i][k] = str.charAt(k);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if(!visitedNormal[i][k]){
                    normal(i, k);
                    normalCount++;
                }
                if(!visitedDisable[i][k]){
                    disable(i, k);
                    disableCount++;
                }
            }
        }

        System.out.println(normalCount+" "+disableCount);
    }

    public static void normal(int i , int j){

        Queue<Node> q = new LinkedList<>();
        visitedNormal[i][j] = true;
        q.add(new Node(i, j));

        while (!q.isEmpty()) {

            Node node = q.remove();

            for (int a = 0; a < 4; a++) {
                int x = node.x + plus_x[a];
                int y = node.y + plus_y[a];

                if(x>-1 && y>-1 && x<n && y<n && !visitedNormal[x][y]){
                    if(arr[node.x][node.y] == arr[x][y]){
                        visitedNormal[x][y] = true;
                        q.add(new Node(x, y));
                    }
                }
            }
        }

    }

    public static void disable(int i , int j){

        Queue<Node> q = new LinkedList<>();
        visitedDisable[i][j] = true;
        q.add(new Node(i, j));

        while (!q.isEmpty()) {

            Node node = q.remove();

            for (int a = 0; a < 4; a++) {
                int x = node.x + plus_x[a];
                int y = node.y + plus_y[a];

                if(x>-1 && y>-1 && x<n && y<n && !visitedDisable[x][y]){
                    if(arr[node.x][node.y] == arr[x][y]
                        || ( arr[node.x][node.y] == 'R' && arr[x][y]=='G')
                            || ( arr[node.x][node.y] == 'G' && arr[x][y]=='R')    ){

                        visitedDisable[x][y] = true;
                        q.add(new Node(x, y));
                    }
                }
            }
        }
    }
}

