import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int x;
        int y;
        public Node(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    static int plusX[] = {0,-1,0};
    static int plusY[] = {-1,0,1};
    static int arr[][];
    static int arr2[][];
    static int m;
    static int n;
    static int d;
    static int 궁수위치1;
    static int 궁수위치2;
    static int 궁수위치3;
    static int 현재성위치;



    static int 적최대수;
    static int 제거한적수;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        arr = new int[m+1][n];
        arr2 = new int[m+1][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr2[i][j] = arr[i][j];
            }
        }



        현재성위치 = m;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {

                    for (int a = 0; a < m; a++) {
                        for (int b = 0; b < n; b++) {
                            arr[a][b] = arr2[a][b];
                        }
                    }

                    궁수위치1 = i;
                    궁수위치2 = j;
                    궁수위치3 = k;
                    simulation();
                }
            }
        }

//        궁수위치1 = 0;
//        궁수위치2 = 1;
//        궁수위치3 = 2;
//        simulation();
        System.out.println(적최대수);

    }
    public static void simulation(){

        현재성위치 = m;
        제거한적수 = 0;
        while (현재성위치!=0) {

            Node n1 =bfs(궁수위치1);
            Node n2 =bfs(궁수위치2);
            Node n3 =bfs(궁수위치3);
            if(arr[n1.x][n1.y]==1){
                arr[n1.x][n1.y] =0;
                제거한적수++;
            }
            if(arr[n2.x][n2.y]==1){
                arr[n2.x][n2.y] =0;
                제거한적수++;
            }
            if(arr[n3.x][n3.y]==1){
                arr[n3.x][n3.y] =0;
                제거한적수++;
            }
            현재성위치--;

        }
        적최대수 = Math.max(제거한적수,적최대수);
    }

    public static Node bfs(int 궁수위치) {

        boolean tf[][] = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(현재성위치-1, 궁수위치));
        if (arr[현재성위치-1][궁수위치] == 1) {
            return new Node(현재성위치-1, 궁수위치);
        }

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            for (int i = 0; i < 3; i++) {
                int xd = node.x + plusX[i];
                int yd = node.y + plusY[i];

                if (xd > -1 && yd > -1 && xd < m && yd < n && !tf[xd][yd]) {
                    tf[xd][yd] = true;
                    queue.add(new Node(xd, yd));
                    if (arr[xd][yd] == 1 && (Math.abs(현재성위치 - xd) + Math.abs(궁수위치 - yd)) <= d) {
                        return new Node(xd, yd);
                    }
                }
            }
        }

        return new Node(m, 0);

    }
}
//만약에 같은 거리에 다른