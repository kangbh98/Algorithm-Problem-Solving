import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {

    public static class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static boolean board[][];

    static int[] move_x = {0, 1, 0, -1};
    static int[] move_y = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());     // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 갯수
        board = new boolean[n+1][n+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = true;
        }

        int L = Integer.parseInt(br.readLine());  // 방향전환 갯수
        Map<Integer,Character> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            map.put(a, b);
        }

        int count = 0;
        int 방향 = 0;
        Deque<node> deque = new LinkedList<>();
        deque.add(new node(1, 1));
        while (true) {


            node no = deque.pollFirst();


            int xd = no.x + move_x[방향];
            int yd = no.y + move_y[방향];

            for (node asdf : deque) {
                if (xd == asdf.x && yd == asdf.y) {
                    System.out.println(count+1);
                    return;
                }
            }

            if(xd>0 && yd >0 && xd< n+1 && yd < n+1){
                deque.addFirst(new node(no.x,no.y));
                deque.addFirst(new node(xd,yd));
                if(board[xd][yd]) {
                    board[xd][yd] =false;
                }else{
                    deque.pollLast();
                }
            }else{
                System.out.println(count+1);
                return;
            }

            count++;
            if (map.containsKey(count)) {
                if(map.get(count)=='D'){
                    방향 +=1;
                    if(방향>3){
                        방향-=4;
                    }
                }else{
                    방향 -=1;
                    if(방향<0){
                        방향+=4;
                    }
                }
            }
        }
    }
}
