
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
    static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int arr[][] = new int[100][100];
    static boolean visited[][] = new boolean[100][100];
    static int start_y;
    static int end_y;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
          String c = br.readLine();

          visited = new boolean[100][100];
          
          for (int i = 0; i < 100; i++) {
              str = new StringTokenizer(br.readLine());
              for (int j = 0; j < 100; j++) {
                  arr[i][j] = Integer.parseInt(str.nextToken());
              }
          }

          for (int i = 0; i < 100; i++) {
              if (arr[99][i] == 2) {
                  start_y = i;
                  break;
              }
          }

          bfs(99, start_y);
          System.out.println("#" + test_case + " " + end_y);
        }
    }

    static void bfs(int x, int y) {

        Queue<node> queue = new LinkedList<node>();
        queue.add(new node(x, y));
        visited[x][y] =true;

        int x_move[] = {0, 0, -1};
        int y_move[] = {-1, 1, 0};

        while (!queue.isEmpty()){
            node node = queue.remove();

            int x1 = node.x;
            int y1 = node.y;

            for (int i = 0; i < 3; i++) {
                int x2 = x1 + x_move[i];
                int y2 = y1 + y_move[i];

                if((x2 > -1 && x2 < 100) && (y2 > -1 && y2 < 100) && !visited[x2][y2] && arr[x2][y2]==1){
                    visited[x2][y2] = true;
                    end_y = y2;
                    queue.add(new node(x2,y2));
                    break;
                }
            }
        }
    }













}