import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n;
    static int arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];

        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = s.charAt(j-1)-'0';
            }
        }
        recursion(1,1,n,n);

        System.out.println(sb);
    }

    public static void recursion(int first_x,int first_y, int end_x, int end_y) {

        boolean flag = true;

        for (int i = first_x; i <= end_x; i++) {
            for (int j = first_y; j <= end_y; j++) {
                if(arr[first_x][first_y]!=arr[i][j]){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }

        if(flag){
            sb.append(arr[first_x][first_y]);
        }else{
            int plus = (end_x-first_x+1)/2;
            sb.append("(");
            recursion(first_x,first_y,end_x-plus,end_y-plus);
            recursion(first_x,first_y+plus,end_x-plus,end_y);
            recursion(first_x+plus,first_y,end_x,end_y-plus);
            recursion(first_x+plus,first_y+plus,end_x,end_y);
            sb.append(")");
        }
    }
}

