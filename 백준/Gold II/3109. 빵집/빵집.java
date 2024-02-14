import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    static char arr[][];
    static int count = 0;
    static int r;
    static int c;
    static boolean flag = false;

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

        for (int i = 0; i < r; i++) {
            flag = false;
            dfs(i,0);
        }
        System.out.println(count);
    }
    public static void dfs(int x , int y){


        if(flag){
            return;
        } else if(x < 0 || y < 0 || x > r-1){
            return;
        }else if(arr[x][y] == 'x'){
            return;
        }else if (y == c - 1) {
            count++;
            arr[x][y] = 'x';
//            cal();
            flag = true;
            return;
        }

        arr[x][y] = 'x';
        dfs(x-1,y+1);
        dfs(x,y+1);
        dfs(x+1,y+1);

    }

//    public static void cal(){
//
//
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//            System.out.println(count);
//    }
}