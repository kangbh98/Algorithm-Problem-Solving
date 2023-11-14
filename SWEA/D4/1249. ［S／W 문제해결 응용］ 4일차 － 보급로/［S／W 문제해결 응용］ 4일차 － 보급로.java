
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    static int ans[][];
    static int map[][];
    static boolean visited[][];
    static int min;
    static int n;


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            ans = new int[n][n];
            visited = new boolean[n][n];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j)-'0';
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
            ans[0][0]=0;
            bfs(0,0);

            System.out.println("#" + test_case + " " + min);
        }
    }
    public static void bfs(int x, int y){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        int arr[] = {0, 0, -1, 1};
        int arr2[] = {-1, 1, 0, 0};

        while (!queue.isEmpty()){
            Node node = queue.remove();

            int x1 = node.x;
            int y1 = node.y;

            if (x1 == n - 1 && y1 == n - 1) {
                if (min >= ans[n - 1][n - 1]) {
                    min = ans[n - 1][n - 1];
                }
            }

            for (int i = 0; i < 4; i++) {
                int xd = x1+arr[i];
                int yd = y1 +arr2[i];

                if (( xd > -1 && xd < n) && (yd > -1 && yd < n) && ans[xd][yd] > ans[x1][y1] + map[xd][yd]) {
                    ans[xd][yd] = ans[x1][y1] + map[xd][yd];
                    queue.add(new Node(xd, yd));
                }
            }
        }
    }
}