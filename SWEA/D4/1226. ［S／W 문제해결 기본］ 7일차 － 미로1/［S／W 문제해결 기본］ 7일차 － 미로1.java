
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
    static int arr[][] = new int[16][16];
    static boolean visited[][] = new boolean[16][16];
    static boolean flag = false;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
          String c = br.readLine();

          visited = new boolean[16][16];
          flag =false;
          int x =0;
          int y =0;

          for (int i = 0; i < 16; i++) {
              String st = br.readLine();
              for (int j = 0; j < 16; j++) {
                  arr[i][j] = st.charAt(j)-'0';
                  if(arr[i][j]==2){
                      x = i;
                      y = j;
                  }
              }
          }

          bfs(x, y);
          if(flag==true){
              System.out.println("#"+test_case+" "+ 1);
          }else {
              System.out.println("#"+test_case+" "+ 0);

          }
        }
    }

    static void bfs(int x, int y) {

        Queue<node> queue = new LinkedList<node>();
        queue.add(new node(x, y));
        visited[x][y] =true;

        int x_move[] = {0, 0, -1,1};
        int y_move[] = {-1, 1, 0,0};

        while (!queue.isEmpty()){
            node node = queue.remove();

            int x1 = node.x;
            int y1 = node.y;

            for (int i = 0; i < 4; i++) {
                int x2 = x1 + x_move[i];
                int y2 = y1 + y_move[i];

                if((x2 > -1 && x2 < 16) && (y2 > -1 && y2 < 16) && !visited[x2][y2] && arr[x2][y2]!=1){
                    visited[x2][y2] = true;
                    if(arr[x2][y2]==3){
                        flag = true;
                    }
                    queue.add(new node(x2,y2));
                }
            }
        }
    }













}