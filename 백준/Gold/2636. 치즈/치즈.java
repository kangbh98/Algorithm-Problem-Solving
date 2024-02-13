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

    static int arr[][];
    static boolean tf[][];
    static int n;
    static int m;
    static int count=0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 첫번째 줄 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) count++;
            }
        }


//        System.out.println(count);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int time = 0;

        while(count>0){

            tf = new boolean[n][m];
            first_set();
            int num = cal();
            time++;
            if(count-num<=0){
                break;
            }else{
                count = count - num;
            }

        }

        System.out.println(time);
        System.out.println(count);
    }





    public static void first_set(){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        tf[0][0] = true;

        while (!q.isEmpty()) {

            Node node = q.remove();

            for (int i = 0; i < 4; i++) {

                int x = node.x + plus_x[i];
                int y = node.y + plus_y[i];

                if( x >-1 && y > -1 && x < n && y < m && arr[x][y]==0 && !tf[x][y]){
                    tf[x][y] = true;
                    q.add(new Node(x, y));
                }
            }
        }
    }

    public static int cal(){

        int num = 0;
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(arr[i][j]==1){

                    for (int a = 0; a < 4; a++) {

                        int x = i + plus_x[a];
                        int y = j + plus_y[a];

                        if (x > -1 && y > -1 && x < n && y < m && tf[x][y]) {
                            q.add(new Node(i, j));
                            break;
                        }
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Node node = q.remove();
            arr[node.x][node.y] =0;
            tf[node.x][node.y] = true;
            num++;
        }
        return num;
    }
}

