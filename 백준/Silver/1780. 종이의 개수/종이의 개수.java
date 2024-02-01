import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n;
    static int arr[][];
    static int ans[] = new int[3];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(1,1,n,n);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
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
            ans[arr[first_x][first_y]+1]++;
        }else{
            int plus = (end_x-first_x+1)/3;
            recursion(first_x,first_y,end_x-2*plus,end_y-2*plus);
            recursion(first_x,first_y+plus,end_x-2*plus,end_y-plus);
            recursion(first_x,first_y+2*plus,end_x-2*plus,end_y);

            recursion(first_x+plus,first_y,end_x-plus,end_y-2*plus);
            recursion(first_x+plus,first_y+plus,end_x-plus,end_y-plus);
            recursion(first_x+plus,first_y+2*plus,end_x-plus,end_y);

            recursion(first_x+2*plus,first_y,end_x,end_y-2*plus);
            recursion(first_x+2*plus,first_y+plus,end_x,end_y-plus);
            recursion(first_x+2*plus,first_y+2*plus,end_x,end_y);
        }
    }
}

