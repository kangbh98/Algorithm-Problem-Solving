import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    static class Node{
        int x;
        int y;

        public Node(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    static int plus_X[] = {0,0,-1,1};
    static int plus_Y[] = {-1,1,0,0};
    static int n;
    static char board[][];
    static ArrayList<Node> list = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][n];

        for(int i = 0 ; i < n ; i++){
            st  = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                board[i][j] = st.nextToken().charAt(0);

                if(board[i][j] == 'T'){
                    list.add(new Node(i, j));
                }
            }
        }

        recursion(0,0);
        System.out.println("NO");
    }

    public static void recursion(int depth,int num){

        if(depth == 3){
            check();
            return;
        }

        for(int i = num ; i < n*n ; i++) {

            int xd = i / n;
            int yd = i % n;

            if(board[xd][yd] == 'X'){
//                System.out.println(depth+" "+ xd+" "+yd);
                board[xd][yd] = 'O';
                recursion(depth+1,i+1);
                board[xd][yd] = 'X';
            }
        }
    }

    public static void check(){


        for(Node node1 : list){

            for(int i = 0 ; i < 4 ; i++){

                int xd = node1.x;
                int yd = node1.y;

                while (true){

                    xd += plus_X[i];
                    yd += plus_Y[i];

                    if(xd < 0 || yd < 0 || xd > n-1 || yd > n-1) {
                        break;
                    }else if(board[xd][yd]== 'O') {
                        break;
                    }else if(board[xd][yd]== 'S'){
                        return;
                    }
                }

            }
        }
        

        System.out.println("YES");
        System.exit(0);

    }
}