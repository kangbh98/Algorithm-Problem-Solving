import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start_x = 0;
        int start_y = 0;
        int end_x = n-1;
        int end_y = m-1;

        while (start_x < end_x && start_y < end_y) {

            Deque<Integer> deque = new LinkedList<>();

            for (int i = start_y; i < end_y; i++) {
                deque.add(arr[start_x][i]);
            }

            for(int i = start_x; i < end_x ;i++){
                deque.add(arr[i][end_y]);
            }

            for (int i = end_y; i > start_y; i--) {
                deque.add(arr[end_x][i]);
            }

            for (int i = end_x; i > start_x; i--) {
                deque.add(arr[i][start_y]);
            }

            for (int i = 0; i < r; i++) {
                deque.addLast(deque.pollFirst());
            }

            ////////////////// 넣기
            for (int i = start_y; i < end_y; i++) {
                arr[start_x][i] = deque.pollFirst();
            }

            for(int i = start_x; i < end_x ;i++){
                arr[i][end_y] = deque.pollFirst();
            }

            for (int i = end_y; i > start_y; i--) {
                arr[end_x][i] = deque.pollFirst();
            }

            for (int i = end_x; i > start_x; i--) {
                arr[i][start_y] =deque.pollFirst();
            }



            start_x++;
            start_y++;
            end_x--;
            end_y--;
        }

        for(int x[] : arr){
            for(int i : x){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}