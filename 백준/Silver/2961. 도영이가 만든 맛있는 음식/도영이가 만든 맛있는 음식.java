import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int n;
    static int arr[][];
    static int total = Integer.MAX_VALUE;
    static boolean tf[];



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        tf = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        recursion(0,1,0);
        System.out.println(total);
    }

    public static void recursion(int start,int sour,int bitter){

        if(start == n){
            boolean flag =false;
            for(int i = 0 ; i < n;i++){
                if (tf[i]) {
                    flag = true;
                }
            }
            if(flag){
                total = Math.min(total, Math.abs(bitter - sour));
            }
            return;
        }

        for (int i = start; i < n; i++) {

            if(!tf[i]){
                tf[i] = true;
                recursion(i+1,sour*arr[i][0],bitter+arr[i][1]);
                tf[i] = false;
                recursion(i+1,sour,bitter);
            }
        }
    }

}

