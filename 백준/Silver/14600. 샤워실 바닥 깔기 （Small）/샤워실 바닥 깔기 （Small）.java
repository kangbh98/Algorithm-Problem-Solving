import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n;
    static int k;
    static int x;
    static int y;
    static int arr[][];
    static int count = 1;
    static int max_count = 9;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = (int) Math.pow(2,n);
        arr = new int[k][k];




        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken())-1;
        x = arr.length - Integer.parseInt(st.nextToken());
        arr[x][y] = -1;

        recursion_2(0,0,k-1,k-1);
        for (int[] arr : arr) {
            for(int i: arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }


    public static void recursion_2(int first_x,int first_y,int end_x,int end_y){
        int length =(end_x-first_x+1);

        if( length == 2){
            if(x>=first_x && x<=end_x && y>=first_y && y<=end_y){
                for(int i = first_x; i<= end_x ;i++){
                    for(int j = first_y; j <= end_y ; j++ ){
                        if (i != x || j != y) {
                            arr[i][j] = count;
                        }
                    }
                }
                count++;

            }else{
                for(int i = first_x; i<= end_x ;i++){
                    for(int j = first_y; j <= end_y ; j++ ){
                        if(i!= 0 && i!= k-1 && j !=0 && j!=k-1){
                            arr[i][j] = max_count;
                        }else{
                            arr[i][j] = count;
                        }
                    }
                }
                count++;
            }
            return;
        }

        int length_d = length/2;

        recursion_2(first_x, first_y, end_x - length_d, end_y - length_d);
        recursion_2(first_x+length_d, first_y, end_x, end_y - length_d);
        recursion_2(first_x, first_y+length_d, end_x-length_d, end_y);
        recursion_2(first_x+length_d, first_y+length_d, end_x, end_y);

    }
}

