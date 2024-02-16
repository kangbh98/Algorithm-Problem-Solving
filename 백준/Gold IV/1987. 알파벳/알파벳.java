import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    static class Node{
//        int x;
//        int y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }


    static char arr[][];
    static HashSet<Character> visited = new HashSet<>();
    static int plusX[] = {0, 0, -1, 1};
    static int plusY[] = {-1, 1, 0, 0};
    static int r;
    static int c;

    static int maxDepth = 1 ;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        recursion(0,0,0);
        System.out.println(maxDepth);
    }

    public static void recursion(int x, int y,int depth) {

        maxDepth = Math.max(maxDepth, depth);
        if(!visited.contains(arr[x][y])){

            visited.add(arr[x][y]);
            for (int i = 0; i < 4; i++) {
                int xd = x + plusX[i];
                int yd = y + plusY[i];

                if(xd > -1 && yd > -1 && xd < r && yd < c){
                    recursion(xd,yd,depth+1);
                }
            }
            visited.remove(arr[x][y]);
        }
    }
}