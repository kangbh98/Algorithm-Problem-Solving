import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{

    public static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String arr[][];
    public static boolean tf[][];
    public static int count = 0;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        tf = new boolean[n][m];
        Queue<node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < m; k++) {
                arr[i][k] = String.valueOf(s.charAt(k));
                if (arr[i][k].equals("I")) {
                    queue.add(new node(i, k));
                    tf[i][k] = true;
                }
            }
        }

        bfs(queue);

        if (count == 0) {
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }

    public static void bfs(Queue<node> queue) {

        int num1[] = {-1, 1, 0, 0};
        int num2[] = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            node remove = queue.remove();

            int x = remove.x;
            int y = remove.y;

            for (int i = 0; i < 4; i++) {

                int xd = x + num1[i];
                int yd = y + num2[i];

                if (xd > -1 && n > xd && yd > -1 && yd < m && !tf[xd][yd] && !arr[xd][yd].equals("X")) {

                    queue.add(new node(xd, yd));
                    tf[xd][yd] = true;
                    if (arr[xd][yd].equals("P")) {
                        count++;
                    }
                }
            }
        }

    }
}